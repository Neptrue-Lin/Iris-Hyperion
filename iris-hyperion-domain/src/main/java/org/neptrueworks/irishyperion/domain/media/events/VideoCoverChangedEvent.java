package org.neptrueworks.irishyperion.domain.media.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VideoCoverChangedEvent extends DomainEvent {
    private final VideoProfileIdentifier video;
    private final UserIdentifier changedBy;
    private final LocalDateTime changedAt;
}
