package org.neptrueworks.irishyperion.domain.social.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public record FollowUserCommand(UserIdentifier follower, UserIdentifier followee) implements Command {
}
