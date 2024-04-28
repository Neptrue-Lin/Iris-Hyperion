package org.neptrueworks.irishyperion.domain.accounting.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public record UnlockAccountCommand(UserIdentifier userId) implements Command {
}
