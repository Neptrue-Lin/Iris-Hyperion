package org.neptrueworks.irishyperion.domain.media.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoCategoryIdentifier;

import java.net.URI;
import java.util.Collection;

public record PostVideoCommand(UserIdentifier author, String title, String description,
                               VideoCategoryIdentifier category, Collection<TopicTagIdentifier> tags,
                               Collection<UserIdentifier> creators, URI cover, URI content) implements Command {
}
