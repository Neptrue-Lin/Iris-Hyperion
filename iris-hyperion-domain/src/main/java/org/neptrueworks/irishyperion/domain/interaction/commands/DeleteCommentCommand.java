package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;

@Getter
@AllArgsConstructor
public class DeleteCommentCommand extends Command {
    private final UserIdentifier userId;
    private final CommentProfileIdentifier commentId;
}
