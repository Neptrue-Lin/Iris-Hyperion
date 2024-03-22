package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class RemoveVideoCreatorCommand extends Command {
    private UserIdentifier author;
    private VideoProfileIdentifier video;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveVideoCreatorCommand that = (RemoveVideoCreatorCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, creator);
    }

    private UserIdentifier creator;


}
