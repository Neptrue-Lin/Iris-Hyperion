package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class FollowUserCommand extends Command {
    private final UserIdentifier follower;
    private final UserIdentifier followee;
}
