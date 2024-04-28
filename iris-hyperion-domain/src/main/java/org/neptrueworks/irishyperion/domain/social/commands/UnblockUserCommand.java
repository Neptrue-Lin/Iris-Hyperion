package org.neptrueworks.irishyperion.domain.social.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public record UnblockUserCommand(UserIdentifier unblockedUser, UserIdentifier unblockedBy) implements Command {
}
