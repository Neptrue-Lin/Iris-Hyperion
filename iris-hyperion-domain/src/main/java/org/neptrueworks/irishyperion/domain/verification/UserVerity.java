package org.neptrueworks.irishyperion.domain.verification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.identification.exceptions.VerificationDisabledException;
import org.neptrueworks.irishyperion.domain.verification.commands.*;
import org.neptrueworks.irishyperion.domain.verification.events.*;
import org.neptrueworks.irishyperion.domain.verification.exceptions.VerificationCredentialDeletedException;
import org.neptrueworks.irishyperion.domain.verification.exceptions.VerificationCredentialExpiredException;
import org.neptrueworks.irishyperion.domain.verification.exceptions.VerificationCredentialInvalidatedException;
import org.neptrueworks.irishyperion.domain.verification.exceptions.VerificationCredentialLockedException;

import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder
public class UserVerity extends AggregateRoot {
    private UserVerityIdentifier identifier;
    private UserIdentifier userId;
    private UserIdentityIdentifier identityIdentifier;
    private VerificationCredential credential;
    private boolean isVerificationEnabled;
    private boolean isExpired;
    private boolean isLocked;
    private boolean isInvalid;
    private boolean isDeleted;

    public void resetCredential(EventPublisher eventPublisher, ResetCredentialCommand command) {
        this.credential = command.getCredential();
        eventPublisher.publish(new CredentialResetEvent(this.getUserId(), this.getIdentityIdentifier(),
                this.getIdentifier(), this.getCredential(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void verifyCredential(EventPublisher eventPublisher, VerificationCredential credential) {
        this.checkVerifiability();

        if (!Objects.equals(this.getCredential(), credential)) {
            eventPublisher.publish(new CredentialIncorrectEvent(this.getUserId(), this.getIdentifier(),
                    eventPublisher.getChronographService().currentDateTime()));
            return;
        }

        eventPublisher.publish(new CredentialVerifiedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void checkVerifiability(){
        if (!this.isVerificationEnabled())
            throw new VerificationDisabledException(this.getUserId(), this.getIdentifier());
        if (this.isInvalid)
            throw new VerificationCredentialInvalidatedException(this.getUserId(), this.getIdentifier());
        if (this.isLocked)
            throw new VerificationCredentialLockedException(this.getUserId(), this.getIdentifier());
        if (this.isExpired)
            throw new VerificationCredentialExpiredException(this.getUserId(), this.getIdentifier());
        if (this.isDeleted)
            throw new VerificationCredentialDeletedException(this.getUserId(), this.getIdentifier());
    }

    public void enableVerification(EventPublisher eventPublisher, EnableVerificationCommand command) {
        if (this.isVerificationEnabled())
            return;
        this.isVerificationEnabled = true;
        eventPublisher.publish(new VerificationEnabledEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void disableVerification(EventPublisher eventPublisher, DisableVerificationCommand command) {
        if (!this.isVerificationEnabled())
            return;
        this.isVerificationEnabled = false;
        eventPublisher.publish(new VerificationDisabledEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void lockUserVerity(EventPublisher eventPublisher, LockVerityCommand command) {
        if (this.isLocked())
            return;
        this.isLocked = true;
        eventPublisher.publish(new VerityLockedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void unlockUserVerity(EventPublisher eventPublisher, UnlockVerityCommand command) {
        if (!this.isLocked())
            return;
        this.isLocked = false;
        eventPublisher.publish(new VerityUnlockedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void removeUserVerity(EventPublisher eventPublisher, RemoveVerityCommand command) {
        if (this.isDeleted())
            return;
        this.isDeleted = true;
        eventPublisher.publish(new VerityRemovedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void invalidateUserVerity(EventPublisher eventPublisher, InvalidateVerityCommand command) {
        if (this.isInvalid())
            return;
        this.isInvalid = true;
        eventPublisher.publish(new VerityInvalidatedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void expireUserVerity(EventPublisher eventPublisher, ExpireVerityCommand command) {
        if (this.isExpired())
            return;
        this.isExpired = true;
        eventPublisher.publish(new VerityExpiredEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
