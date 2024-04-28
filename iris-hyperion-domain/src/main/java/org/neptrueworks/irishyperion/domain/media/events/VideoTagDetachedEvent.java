package org.neptrueworks.irishyperion.domain.media.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.time.LocalDateTime;

public record VideoTagDetachedEvent(VideoProfileIdentifier video, TopicTagIdentifier tag, UserIdentifier detachedBy,
                                    LocalDateTime detachedAt) implements DomainEvent {
}
