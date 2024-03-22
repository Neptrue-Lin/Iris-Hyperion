package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class AttachVideoTagCommand extends Command {
    private UserIdentifier author;
    private VideoProfileIdentifier video;
    private TopicTagIdentifier tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachVideoTagCommand that = (AttachVideoTagCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, tag);
    }


}
