package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

@Getter
@AllArgsConstructor
public class RemoveIdentityCommand extends Command {
    private final UserIdentityIdentifier identifier;
}
