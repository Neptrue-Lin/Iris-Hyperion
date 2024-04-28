package org.neptrueworks.irishyperion.domain.profiling.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record UsernameChangedEvent(String username, UserIdentifier changedBy,
                                   LocalDateTime changedAt) implements DomainEvent {
}
