package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class UnblockUserCommand extends Command {
    private final UserIdentifier unblockedUser;
    private final UserIdentifier unblockedBy;
}
