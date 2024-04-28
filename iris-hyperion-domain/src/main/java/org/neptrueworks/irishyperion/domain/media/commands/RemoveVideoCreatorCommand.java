package org.neptrueworks.irishyperion.domain.media.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

public record RemoveVideoCreatorCommand(UserIdentifier author, VideoProfileIdentifier video,
                                        UserIdentifier creator) implements Command {
}
