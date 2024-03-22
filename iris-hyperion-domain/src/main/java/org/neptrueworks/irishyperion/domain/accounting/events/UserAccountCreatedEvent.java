package org.neptrueworks.irishyperion.domain.accounting.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAccountCreatedEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final LocalDateTime createdAt;
}
