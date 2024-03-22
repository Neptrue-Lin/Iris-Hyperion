package org.neptrueworks.irishyperion.domain.accounting;

import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

public abstract class UserFacadeFactory {
    public abstract void create(EventPublisher eventPublisher, IdentificationClaim identificationClaim,
                                VerificationCredential verificationCredential, String username);
}
