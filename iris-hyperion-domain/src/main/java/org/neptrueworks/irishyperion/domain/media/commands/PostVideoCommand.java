package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoCategoryIdentifier;

import java.net.URI;
import java.util.Collection;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class PostVideoCommand extends Command {
    private final UserIdentifier author;
    private final String title;
    private final String introduction;
    private final VideoCategoryIdentifier category;
    private final Collection<TopicTagIdentifier> tags;
    private final Collection<UserIdentifier> creators;
    private final URI cover;
    private final URI content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostVideoCommand that = (PostVideoCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(title, that.title)
                && Objects.equals(introduction, that.introduction) && Objects.equals(category, that.category)
                && Objects.equals(tags, that.tags) && Objects.equals(creators, that.creators)
                && Objects.equals(cover, that.cover) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, introduction, category, tags, creators, cover, content);
    }
}
