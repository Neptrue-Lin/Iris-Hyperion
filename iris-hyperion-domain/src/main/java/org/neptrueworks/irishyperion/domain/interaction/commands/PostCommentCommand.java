package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

@Getter
@AllArgsConstructor
public class PostCommentCommand extends Command {
    private final UserIdentifier userId;
    private final String content;
    private final InteractionIdentifier postedTo;
}
