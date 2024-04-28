package org.neptrueworks.irishyperion.domain.media.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

public record ChangeVideoDescriptionCommand(UserIdentifier author, VideoProfileIdentifier video,
                                            String description) implements Command {
}
