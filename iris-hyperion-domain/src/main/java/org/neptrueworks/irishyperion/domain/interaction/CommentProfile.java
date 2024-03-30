package org.neptrueworks.irishyperion.domain.interaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.commands.DeleteCommentCommand;
import org.neptrueworks.irishyperion.domain.interaction.events.CommentDeletedEvent;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentProfile extends AggregateRoot {
    private CommentProfileIdentifier commentId;
    private InteractionIdentifier postedTo;
    private UserIdentifier postedBy;
    private LocalDateTime postedAt;
    private String content;
    private boolean isDeleted;

    public void deleteComment(EventPublisher eventPublisher, DeleteCommentCommand command) {
        if(this.isDeleted())
            return;
        this.isDeleted = true;
        eventPublisher.publish(new CommentDeletedEvent(this.getCommentId(), this.getPostedBy(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
