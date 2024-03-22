package org.neptrueworks.irishyperion.domain.social.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserUnfollowedEvent extends DomainEvent {
    private UserIdentifier unfollower;
    private UserIdentifier unfollowee;
    private LocalDateTime blockedAt;
}
