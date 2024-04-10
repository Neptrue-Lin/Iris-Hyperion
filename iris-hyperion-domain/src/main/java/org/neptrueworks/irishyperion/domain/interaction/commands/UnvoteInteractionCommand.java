package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

@Getter
@AllArgsConstructor
public class UnvoteInteractionCommand extends Command {
    private final InteractionIdentifier interactionId;
    private final UserIdentifier userId;
}
