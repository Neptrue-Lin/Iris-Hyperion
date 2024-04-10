package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class UnfollowUserCommand extends Command {
    private final UserIdentifier unfollower;
    private final UserIdentifier unfollowee;
}
