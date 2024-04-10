package org.neptrueworks.irishyperion.domain.verification;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

public interface UserVerityFactory {
    UserVerity create(EventPublisher eventPublisher, UserIdentifier userId,
                      UserIdentityIdentifier userIdentityIdentifier, VerificationCredential verificationCredential);
}
