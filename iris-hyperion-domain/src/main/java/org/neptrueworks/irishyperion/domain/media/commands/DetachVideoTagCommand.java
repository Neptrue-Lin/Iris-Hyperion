package org.neptrueworks.irishyperion.domain.media.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

public record DetachVideoTagCommand(UserIdentifier author, VideoProfileIdentifier video,
                                    TopicTagIdentifier tag) implements Command {
}
