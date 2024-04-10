package org.neptrueworks.irishyperion.domain.verification;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.common.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.events.VerityAddedEvent;

public class UserVerityDefaultFactory implements UserVerityFactory {
    private IIdentifierGeneratable<UserVerityIdentifier> identifierGenerator;

    @Override
    public UserVerity create(EventPublisher eventPublisher, UserIdentifier userId, UserIdentityIdentifier userIdentityIdentifier, VerificationCredential verificationCredential) {
        UserVerity userVerity = UserVerity.builder()
                .identifier(this.identifierGenerator.nextIdentifier())
                .userIdentityIdentifier(userIdentityIdentifier)
                .userId(userId)
                .isVerificationEnabled(false)
                .isLocked(false)
                .isExpired(false)
                .isInvalid(false)
                .isDeleted(false)
                .build();
        eventPublisher.publish(new VerityAddedEvent(userVerity.getIdentifier(), userVerity.getUserId(),
                userVerity.getUserIdentityIdentifier(), userVerity.getCredential(),
                eventPublisher.getChronographService().currentDateTime()));
        return userVerity;
    }
}
