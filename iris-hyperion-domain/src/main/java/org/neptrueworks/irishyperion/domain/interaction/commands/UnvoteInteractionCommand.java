package org.neptrueworks.irishyperion.domain.interaction.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

public record UnvoteInteractionCommand(InteractionIdentifier interactionId, UserIdentifier userId) implements Command {
}
