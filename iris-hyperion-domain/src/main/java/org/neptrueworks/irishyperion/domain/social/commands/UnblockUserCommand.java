package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class UnblockUserCommand extends Command {
    private UserIdentifier unblockedUser;
    private UserIdentifier unblockedBy;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnblockUserCommand that = (UnblockUserCommand) o;
        return Objects.equals(unblockedUser, that.unblockedUser) && Objects.equals(unblockedBy, that.unblockedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unblockedUser, unblockedBy);
    }
}
