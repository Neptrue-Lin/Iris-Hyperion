package org.neptrueworks.irishyperion.domain.identification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record AddIdentityCommand(UserIdentifier userId, IdentificationClaim identificationClaim,
                                 LocalDateTime identifierDeactivateAt) implements Command {
}
