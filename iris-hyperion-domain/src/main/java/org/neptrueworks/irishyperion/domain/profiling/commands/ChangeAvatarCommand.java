package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.net.URI;

@Getter
@AllArgsConstructor
public class ChangeAvatarCommand extends Command {
    private final UserIdentifier userId;
    private final Integer fileSize;
    private final URI avatar;
}
