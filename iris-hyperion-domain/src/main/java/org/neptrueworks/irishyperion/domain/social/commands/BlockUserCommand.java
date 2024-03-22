package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class BlockUserCommand extends Command {
    private UserIdentifier blockedUser;
    private UserIdentifier blockedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockUserCommand that = (BlockUserCommand) o;
        return Objects.equals(blockedUser, that.blockedUser) && Objects.equals(blockedBy, that.blockedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockedUser, blockedBy);
    }
}
