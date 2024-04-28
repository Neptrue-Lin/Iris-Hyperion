package org.neptrueworks.irishyperion.domain.interaction.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.time.LocalDateTime;

public record CommentPostedEvent(InteractionIdentifier postedTo, String content, UserIdentifier postedBy,
                                 LocalDateTime postedAt) implements DomainEvent {
}
