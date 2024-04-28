package org.neptrueworks.irishyperion.domain.verification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

public record ExpireVerityCommand(UserIdentifier userId, UserIdentityIdentifier identityIdentifier) implements Command {
}
