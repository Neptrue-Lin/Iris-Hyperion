package org.neptrueworks.irishyperion.domain.media.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VideoCreatorAddedEvent extends DomainEvent {
    private VideoProfileIdentifier video;
    private UserIdentifier creator;
    private UserIdentifier addedBy;
    private LocalDateTime addedAt;
}
