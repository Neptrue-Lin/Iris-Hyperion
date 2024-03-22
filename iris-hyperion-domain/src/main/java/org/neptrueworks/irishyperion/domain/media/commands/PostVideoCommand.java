package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoCategoryIdentifier;

import java.net.URI;
import java.util.Collection;
import java.util.Objects;

@Data
@AllArgsConstructor
public class PostVideoCommand extends Command {
    private UserIdentifier author;
    private String title;
    private String introduction;
    private VideoCategoryIdentifier category;
    private Collection<TopicTagIdentifier> tags;
    private Collection<UserIdentifier> creators;
    private URI cover;
    private URI content;



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
