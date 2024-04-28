package org.neptrueworks.irishyperion.domain.social.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record UserBlockedEvent(UserIdentifier blockedUser, UserIdentifier blockedBy,
                               LocalDateTime blockedAt) implements DomainEvent {
}
