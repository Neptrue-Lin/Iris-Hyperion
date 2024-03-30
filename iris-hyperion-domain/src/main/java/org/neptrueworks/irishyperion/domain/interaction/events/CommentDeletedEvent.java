package org.neptrueworks.irishyperion.domain.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDeletedEvent extends DomainEvent {
    private final CommentProfileIdentifier commentId;
    private final UserIdentifier deletedBy;
    private final LocalDateTime deletedAt;
}
