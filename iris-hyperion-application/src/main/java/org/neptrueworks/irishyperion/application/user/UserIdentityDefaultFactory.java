package org.neptrueworks.irishyperion.application.user;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.core.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.*;
import org.neptrueworks.irishyperion.domain.identification.events.IdentityAddedEvent;
import org.neptrueworks.irishyperion.domain.identification.services.CredentialPatternRestriction;
import org.neptrueworks.irishyperion.domain.identification.services.ICredentialCryptographyService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIdentityDefaultFactory extends UserIdentityFactory {
    private IIdentifierGeneratable<UserIdentityIdentifier> identifierGenerator;
    private ICredentialCryptographyService credentialCryptographyService;
    private CredentialPatternRestriction restriction;

    public UserIdentity create(EventPublisher eventPublisher, UserIdentifier userId,
                               IdentificationClaim identificationClaim, VerificationCredential verificationCredential) {
        UserIdentity userIdentity = UserIdentity.builder()
                .identifier(this.identifierGenerator.nextIdentifier())
                .userId(userId)
                .identificationClaim(identificationClaim)
                .verificationCredential(this.credentialCryptographyService.encrypt(verificationCredential))
                .isIdentificationEnabled(false)
                .isVerificationEnabled(false)
                .isDeleted(false)
                .credentialCryptographyService(this.credentialCryptographyService)
                .restriction(this.restriction)
                .build();

        eventPublisher.publish(new IdentityAddedEvent(userIdentity.getUserId(), userIdentity.getIdentifier(),
                userIdentity.getIdentificationClaim(), userIdentity.getVerificationCredential(), eventPublisher.getChronographService().currentDateTime()));
        return userIdentity;
    }
}
