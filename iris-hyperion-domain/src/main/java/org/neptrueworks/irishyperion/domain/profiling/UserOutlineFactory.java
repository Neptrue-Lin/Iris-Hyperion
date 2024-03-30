package org.neptrueworks.irishyperion.domain.profiling;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class UserOutlineFactory {
    public abstract UserOutline create(EventPublisher eventPublisher, UserIdentifier userId, String username);
}
