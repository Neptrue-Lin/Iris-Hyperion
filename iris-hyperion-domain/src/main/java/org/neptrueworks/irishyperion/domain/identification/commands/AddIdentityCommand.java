package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AddIdentityCommand extends Command {
    private final UserIdentifier userId;
    private final IdentificationClaim identificationClaim;
    private final LocalDateTime identifierDeactivateAt;
}
