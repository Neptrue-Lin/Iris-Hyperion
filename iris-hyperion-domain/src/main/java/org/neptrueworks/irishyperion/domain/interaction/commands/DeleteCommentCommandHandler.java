package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfile;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCommentCommandHandler extends CommandHandler<DeleteCommentCommand> {
    private final CommentProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DeleteCommentCommand command) {
        CommentProfile commentProfile = this.repository.fetchByIdentifierOrError(command.commentId());
        commentProfile.deleteComment(eventPublisher, command);
        this.repository.save(commentProfile);
    }
}
