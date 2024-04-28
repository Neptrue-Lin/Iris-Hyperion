package org.neptrueworks.irishyperion.domain.identification.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.time.LocalDateTime;

public record IdentityUnlockedEvent(UserIdentifier userId, UserIdentityIdentifier identifier,
                                    LocalDateTime unlockedAt) implements DomainEvent {
}
