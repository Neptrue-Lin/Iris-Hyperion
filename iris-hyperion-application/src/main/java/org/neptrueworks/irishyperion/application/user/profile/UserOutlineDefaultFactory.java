package org.neptrueworks.irishyperion.application.user.profile;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.profiling.UserOutline;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineFactory;
import org.neptrueworks.irishyperion.domain.profiling.events.UserOutlineCreatedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserOutlineDefaultFactory extends UserOutlineFactory {
    @Override
    public UserOutline create(EventPublisher eventPublisher, UserIdentifier userId, String username) {
        UserOutline userOutline = UserOutline.builder()
                .userId(userId)
                .username(username)
                .isDeleted(false)
                .build();
        eventPublisher.publish(new UserOutlineCreatedEvent(userId, username, eventPublisher.getChronographService()
                .currentDateTime()));
        return userOutline;
    }
}
