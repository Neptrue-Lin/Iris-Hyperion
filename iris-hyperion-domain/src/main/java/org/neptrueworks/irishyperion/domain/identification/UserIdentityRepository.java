package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.common.Repository;

public abstract class UserIdentityRepository extends Repository<UserIdentity> {
    public abstract UserIdentity fetchByIdentifierOrError(UserIdentityIdentifier identifier);

    public abstract UserIdentity fetchByIdentificationIdentifierOrError(IdentificationClaim identifier);

    public abstract boolean exists(IdentificationClaim identificationClaim);
}
