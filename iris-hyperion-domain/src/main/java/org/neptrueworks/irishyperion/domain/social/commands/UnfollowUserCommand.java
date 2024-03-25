package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class UnfollowUserCommand extends Command {
    private final UserIdentifier unfollower;
    private final UserIdentifier unfollowee;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnfollowUserCommand that = (UnfollowUserCommand) o;
        return Objects.equals(unfollower, that.unfollower) && Objects.equals(unfollowee, that.unfollowee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unfollower, unfollowee);
    }
}
