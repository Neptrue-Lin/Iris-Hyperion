package org.neptrueworks.irishyperion.domain.profiling.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UsernameChangedEvent extends DomainEvent {
    private final String username;
    private final UserIdentifier changedBy;
    private final LocalDateTime changedAt;
}
