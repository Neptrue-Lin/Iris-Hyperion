package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

@Data
@AllArgsConstructor
public class RemoveIdentityCommand extends Command {
    private UserIdentifier userId;
    private UserIdentityIdentifier identifier;
}
