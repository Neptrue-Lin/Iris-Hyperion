package org.neptrueworks.irishyperion.domain.accounting.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public record LockAccountCommand(UserIdentifier userId) implements Command {
}
