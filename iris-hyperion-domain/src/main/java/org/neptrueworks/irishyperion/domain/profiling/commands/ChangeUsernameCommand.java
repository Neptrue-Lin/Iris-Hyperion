package org.neptrueworks.irishyperion.domain.profiling.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public record ChangeUsernameCommand(UserIdentifier userId, String username) implements Command {
}
