package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.commands.*;
import org.neptrueworks.irishyperion.domain.identification.events.*;

@Getter
@AllArgsConstructor
@Builder
public class UserIdentity extends AggregateRoot {
    private UserIdentityIdentifier identifier;
    private UserIdentifier userId;
    private IdentificationClaim identificationClaim;
    private boolean isIdentificationEnabled;
    private boolean isLocked;
    private boolean isDeactivated;
    private boolean isDeleted;

    public void removeUserIdentity(EventPublisher eventPublisher, RemoveIdentityCommand command) {
        if (this.isDeleted())
            return;
        this.isDeleted = true;
        eventPublisher.publish(new IdentityRemovedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void enableIdentification(EventPublisher eventPublisher, EnableIdentificationCommand command) {
        if (this.isIdentificationEnabled())
            return;
        this.isIdentificationEnabled = true;
        eventPublisher.publish(new IdentificationEnabledEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void disableIdentification(EventPublisher eventPublisher, DisableIdentificationCommand command) {
        if (!this.isIdentificationEnabled())
            return;
        this.isIdentificationEnabled = false;
        eventPublisher.publish(new IdentificationDisabledEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void lockUserIdentity(EventPublisher eventPublisher, LockIdentityCommand command) {
        if (this.isLocked())
            return;
        this.isLocked = true;
        eventPublisher.publish(new IdentityLockedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void unlockUserIdentity(EventPublisher eventPublisher, UnlockIdentityCommand command) {
        if (!this.isLocked())
            return;
        this.isLocked = false;
        eventPublisher.publish(new IdentityUnlockedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void deactivateUserIdentity(EventPublisher eventPublisher, DeactivateIdentityCommand command) {
        if (this.isDeactivated())
            return;
        this.isDeactivated = true;
        eventPublisher.publish(new IdentityLockedEvent(this.getUserId(), this.getIdentifier(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
