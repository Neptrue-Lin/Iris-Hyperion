package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class PostCommentCommand extends Command {
    private final UserIdentifier userId;
    private final String content;
    private final InteractionIdentifier postedTo;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentCommand that = (PostCommentCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(content, that.content)
                && Objects.equals(postedTo, that.postedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, content, postedTo);
    }
}
