package org.neptrueworks.irishyperion.domain.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDeletedEvent extends DomainEvent {
    private CommentProfileIdentifier commentId;
    private UserIdentifier deletedBy;
    private LocalDateTime deletedAt;
}
