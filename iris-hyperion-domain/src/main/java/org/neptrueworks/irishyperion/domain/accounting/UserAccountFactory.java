package org.neptrueworks.irishyperion.domain.accounting;

import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class UserAccountFactory {
    public abstract UserAccount create(EventPublisher eventPublisher, UserIdentifier userId);
}
