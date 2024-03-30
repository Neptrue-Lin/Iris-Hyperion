package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;

public abstract class UserIdentityFactory {
    public abstract UserIdentity create(EventPublisher eventPublisher, UserIdentifier userId,
                                        IdentificationClaim identificationClaim);
}
