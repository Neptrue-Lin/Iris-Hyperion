package org.neptrueworks.irishyperion.domain.media.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VideoCreatorRemovedEvent extends DomainEvent {
    private final VideoProfileIdentifier video;
    private final UserIdentifier creator;
    private final UserIdentifier removedBy;
    private final LocalDateTime removedAt;
}
