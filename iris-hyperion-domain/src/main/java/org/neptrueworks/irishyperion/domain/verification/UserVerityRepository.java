package org.neptrueworks.irishyperion.domain.verification;

import org.neptrueworks.irishyperion.domain.common.Repository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

public abstract class UserVerityRepository extends Repository<UserVerity> {
    public abstract UserVerity fetchByIdentifierOrError(UserVerityIdentifier identifier);
    public abstract UserVerity fetchByIdentityIdentifierOrError(UserIdentityIdentifier identifier);
}
