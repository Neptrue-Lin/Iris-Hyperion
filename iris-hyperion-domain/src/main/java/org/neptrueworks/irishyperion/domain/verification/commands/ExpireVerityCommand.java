package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

@Getter
@AllArgsConstructor
public class ExpireVerityCommand extends Command {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identityIdentifier;
}
