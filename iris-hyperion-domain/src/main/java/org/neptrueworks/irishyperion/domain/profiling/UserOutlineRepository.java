package org.neptrueworks.irishyperion.domain.profiling;

import org.neptrueworks.irishyperion.domain.common.Repository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class UserOutlineRepository extends Repository<UserOutline> {
    public abstract UserOutline fetchByIdentifierOrError(UserIdentifier userId);
}
