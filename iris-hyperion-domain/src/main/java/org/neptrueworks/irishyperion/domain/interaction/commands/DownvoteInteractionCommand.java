package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class DownvoteInteractionCommand extends Command {
    private InteractionIdentifier interactionId;
    private UserIdentifier userId;



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
