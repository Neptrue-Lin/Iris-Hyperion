package org.neptrueworks.irishyperion.domain.profiling.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.net.URI;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AvatarChangedEvent extends DomainEvent {
    private String encodedThumbnail;
    private URI avatarURI;
    private UserIdentifier changedBy;
    private LocalDateTime changedAt;
}
