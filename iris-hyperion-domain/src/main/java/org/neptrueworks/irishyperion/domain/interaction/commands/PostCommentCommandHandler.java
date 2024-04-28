package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfile;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileFactory;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostCommentCommandHandler extends CommandHandler<PostCommentCommand> {
    private final CommentProfileRepository repository;
    private final CommentProfileFactory commentProfileFactory;

    @Override
    public void handle(EventPublisher eventPublisher, PostCommentCommand command) {
        CommentProfile commentProfile = this.commentProfileFactory.create(eventPublisher, command.userId(),
                command.postedTo(), command.content());
        this.repository.save(commentProfile);
    }
}
