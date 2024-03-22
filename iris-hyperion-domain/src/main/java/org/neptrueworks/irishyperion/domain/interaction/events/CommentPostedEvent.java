package org.neptrueworks.irishyperion.domain.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentPostedEvent extends DomainEvent {
    private InteractionIdentifier postedTo;
    private String content;
    private UserIdentifier postedBy;
    private LocalDateTime postedAt;
}
