package org.neptrueworks.irishyperion.domain.verification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

public record DisableVerificationCommand(UserVerityIdentifier identifier) implements Command {
}
