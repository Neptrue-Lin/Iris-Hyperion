package org.neptrueworks.irishyperion.domain.interaction.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;

public record DeleteCommentCommand(UserIdentifier userId, CommentProfileIdentifier commentId) implements Command {
}
