package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.net.URI;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class ChangeVideoCoverCommand extends Command {
    private final UserIdentifier author;
    private final VideoProfileIdentifier video;
    private final URI cover;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeVideoCoverCommand that = (ChangeVideoCoverCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(cover, that.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, cover);
    }
}
