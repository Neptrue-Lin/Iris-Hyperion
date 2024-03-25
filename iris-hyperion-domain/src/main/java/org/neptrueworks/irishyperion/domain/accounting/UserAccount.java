package org.neptrueworks.irishyperion.domain.accounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.accounting.commands.*;
import org.neptrueworks.irishyperion.domain.accounting.events.*;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountCancelledException;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountDeletedException;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountLockedException;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
@Builder
public class UserAccount extends AggregateRoot {
    private final UserIdentifier identifier;
    private boolean isLocked;
    private boolean isCancelled;
    private boolean isDeleted;
    private boolean isSignedIn;

    public void deleteAccount(EventPublisher eventPublisher, DeleteAccountCommand command) {
        if (this.isDeleted())
            return;
        this.isDeleted = true;
        eventPublisher.publish(new AccountDeletedEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void cancelAccount(EventPublisher eventPublisher, CancelAccountCommand command) {
        if (this.isCancelled())
            return;
        this.isCancelled = true;
        eventPublisher.publish(new AccountCancelledEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void restoreAccount(EventPublisher eventPublisher, RestoreAccountCommand command) {
        if (this.isDeleted())
            throw new AccountDeletedException(this.getIdentifier());
        if (!this.isCancelled())
            return;
        this.isCancelled = false;
        eventPublisher.publish(new AccountRestoredEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void lockAccount(EventPublisher eventPublisher, LockAccountCommand command) {
        if (this.isLocked())
            return;
        this.isLocked = true;
        eventPublisher.publish(new AccountLockedEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void unlockAccount(EventPublisher eventPublisher, UnlockAccountCommand command) {
        if (!this.isLocked())
            return;
        this.isLocked = false;
        eventPublisher.publish(new AccountUnlockedEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void signInAccount(EventPublisher eventPublisher, SignInAccountCommand command) {
        this.checkAccountLoggability();

        if (this.isSignedIn())
            return;

        this.isSignedIn = true;
        eventPublisher.publish(new AccountSignedInEvent(this.getIdentifier(), command.getIdentificationClaim(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void checkAccountLoggability() {
        if (this.isLocked())
            throw new AccountLockedException(this.getIdentifier());
        if (this.isCancelled())
            throw new AccountCancelledException(this.getIdentifier());
        if (this.isDeleted())
            throw new AccountDeletedException(this.getIdentifier());
    }

    public void signOutAccount(EventPublisher eventPublisher, SignOutAccountCommand command) {
        if (!this.isSignedIn())
            return;
        this.isSignedIn = false;
        eventPublisher.publish(new AccountSignedOutEvent(this.getIdentifier(), eventPublisher.getChronographService().currentDateTime()));
    }
}
