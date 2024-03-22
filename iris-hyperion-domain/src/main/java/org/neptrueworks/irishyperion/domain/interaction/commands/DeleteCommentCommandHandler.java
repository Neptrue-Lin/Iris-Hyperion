package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfile;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCommentCommandHandler extends CommandHandler<DeleteCommentCommand> {
    private CommentProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DeleteCommentCommand command) {
        CommentProfile commentProfile = this.repository.fetchByIdentifierOrError(command.getCommentId());
        commentProfile.deleteComment(eventPublisher, command);
        this.repository.save(commentProfile);
    }
}
