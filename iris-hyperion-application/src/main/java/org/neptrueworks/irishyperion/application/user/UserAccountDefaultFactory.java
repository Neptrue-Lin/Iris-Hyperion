package org.neptrueworks.irishyperion.application.user;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountFactory;
import org.neptrueworks.irishyperion.domain.accounting.events.AccountRegisteredEvent;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserAccountDefaultFactory extends UserAccountFactory {

    @Override
    public UserAccount create(EventPublisher eventPublisher, UserIdentifier userId) {
        UserAccount userAccount = UserAccount.builder()
                .identifier(userId)
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
