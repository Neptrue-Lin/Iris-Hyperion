package org.neptrueworks.irishyperion.domain.verification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

public record EnableVerificationCommand(UserVerityIdentifier identifier) implements Command {
}
