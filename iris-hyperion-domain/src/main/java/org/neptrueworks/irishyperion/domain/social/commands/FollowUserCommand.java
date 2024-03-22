package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class FollowUserCommand extends Command {
    private UserIdentifier follower;
    private UserIdentifier followee;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowUserCommand that = (FollowUserCommand) o;
        return Objects.equals(follower, that.follower) && Objects.equals(followee, that.followee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(follower, followee);
    }
}
