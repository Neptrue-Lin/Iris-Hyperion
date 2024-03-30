package org.neptrueworks.irishyperion.domain.social.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserBlockedEvent extends DomainEvent {
    private final UserIdentifier blockedUser;
    private final UserIdentifier blockedBy;
    private final LocalDateTime blockedAt;
}
