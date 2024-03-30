package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class DownvoteInteractionCommand extends Command {
    private final InteractionIdentifier interactionId;
    private final UserIdentifier userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownvoteInteractionCommand that = (DownvoteInteractionCommand) o;
        return Objects.equals(interactionId, that.interactionId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interactionId, userId);
    }
}
