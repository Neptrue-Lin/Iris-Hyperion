package org.neptrueworks.irishyperion.domain.interaction.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;

import java.time.LocalDateTime;

public record CommentDeletedEvent(CommentProfileIdentifier commentId, UserIdentifier deletedBy,
                                  LocalDateTime deletedAt) implements DomainEvent {
}
