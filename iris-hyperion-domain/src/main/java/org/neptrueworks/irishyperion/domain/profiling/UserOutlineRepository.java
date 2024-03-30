package org.neptrueworks.irishyperion.domain.profiling;

import org.neptrueworks.irishyperion.domain.common.Repository;

public abstract class UserOutlineRepository extends Repository<UserOutline> {
    public abstract UserOutline fetchByIdentifierOrError(Integer userId);
}
