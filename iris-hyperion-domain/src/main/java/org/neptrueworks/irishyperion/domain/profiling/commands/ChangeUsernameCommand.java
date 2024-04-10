package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class ChangeUsernameCommand extends Command {
    private final UserIdentifier userId;
    private final String username;
}
