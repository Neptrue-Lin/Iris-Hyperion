package org.neptrueworks.irishyperion.domain.identification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

public record RemoveIdentityCommand(UserIdentityIdentifier identifier) implements Command {
}
