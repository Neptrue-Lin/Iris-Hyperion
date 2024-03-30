package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.common.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.events.IdentityAddedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIdentityDefaultFactory extends UserIdentityFactory {
    private IIdentifierGeneratable<UserIdentityIdentifier> identifierGenerator;

    public UserIdentity create(EventPublisher eventPublisher, UserIdentifier userId,
                               IdentificationClaim identificationClaim) {
        UserIdentity userIdentity = UserIdentity.builder()
                .identifier(this.identifierGenerator.nextIdentifier())
                .userId(userId)
                .identificationClaim(identificationClaim)
                .isIdentificationEnabled(false)
                .isVerificationEnabled(false)
                .isDeleted(false)
                .build();

        eventPublisher.publish(new IdentityAddedEvent(userIdentity.getUserId(), userIdentity.getIdentifier(),
                userIdentity.getIdentificationClaim(), eventPublisher.getChronographService().currentDateTime()));
        return userIdentity;
    }
}
