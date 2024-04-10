package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class RestoreAccountCommand extends Command {
    private final UserIdentifier userId;
}
