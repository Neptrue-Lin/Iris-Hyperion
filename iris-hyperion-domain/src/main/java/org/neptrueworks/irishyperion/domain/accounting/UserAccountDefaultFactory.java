package org.neptrueworks.irishyperion.domain.accounting;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.events.AccountRegisteredEvent;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserAccountDefaultFactory extends UserAccountFactory {
    @Override
    public UserAccount create(EventPublisher eventPublisher, UserIdentifier userId, VerificationCredential password) {
        UserAccount userAccount = UserAccount.builder()
                .identifier(userId)
                .credential(password)
                .isCancelled(false)
                .isLocked(false)
                .isDeleted(false)
                .isSignedIn(false)
                .build();
        eventPublisher.publish(new AccountRegisteredEvent(userAccount.getIdentifier(), eventPublisher.getChronographService()
                .currentDateTime()));
        return userAccount;
    }
}
