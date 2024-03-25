package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class AddVideoCreatorCommand extends Command {
    private final UserIdentifier author;
    private final VideoProfileIdentifier video;
    private final UserIdentifier creator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddVideoCreatorCommand that = (AddVideoCreatorCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, creator);
    }


}
