package org.neptrueworks.irishyperion.domain.accounting;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public abstract class UserAccountFactory {
    public abstract UserAccount create(EventPublisher eventPublisher, UserIdentifier userId, VerificationCredential password);
}
