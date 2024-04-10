package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoCategoryIdentifier;

import java.net.URI;
import java.util.Collection;

@Getter
@AllArgsConstructor
public class PostVideoCommand extends Command {
    private final UserIdentifier author;
    private final String title;
    private final String description;
    private final VideoCategoryIdentifier category;
    private final Collection<TopicTagIdentifier> tags;
    private final Collection<UserIdentifier> creators;
    private final URI cover;
    private final URI content;
}
