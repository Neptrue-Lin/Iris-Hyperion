package org.neptrueworks.irishyperion.domain.profiling.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.net.URI;

public record ChangeAvatarCommand(UserIdentifier userId, Integer fileSize, URI avatar) implements Command {
}
