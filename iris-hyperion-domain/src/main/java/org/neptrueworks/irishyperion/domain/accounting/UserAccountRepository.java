package org.neptrueworks.irishyperion.domain.accounting;

import org.neptrueworks.irishyperion.domain.core.Repository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class UserAccountRepository extends Repository<UserAccount> {
    public abstract UserAccount fetchByIdentifierOrError(UserIdentifier userId);
}
