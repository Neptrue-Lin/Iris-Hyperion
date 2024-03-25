package org.neptrueworks.irishyperion.domain.media.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VideoTagAttachedEvent extends DomainEvent {
    private final VideoProfileIdentifier video;
    private final TopicTagIdentifier tag;
    private final UserIdentifier attachedBy;
    private final LocalDateTime attachedAt;
}
