package org.neptrueworks.irishyperion.domain.profiling.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.net.URI;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AvatarChangedEvent extends DomainEvent {
    private final URI avatarURI;
    private final UserIdentifier changedBy;
    private final LocalDateTime changedAt;
}
