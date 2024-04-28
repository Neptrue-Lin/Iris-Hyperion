package org.neptrueworks.irishyperion.domain.profiling.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.net.URI;
import java.time.LocalDateTime;

public record AvatarChangedEvent(URI avatarURI, UserIdentifier changedBy,
                                 LocalDateTime changedAt) implements DomainEvent {
}
