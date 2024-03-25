package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;

import java.net.URI;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class ChangeAvatarCommand extends Command {
    private final Integer userId;
    private final Integer fileSize;
    private final URI avatar;
    private final String avatarThumbnail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeAvatarCommand that = (ChangeAvatarCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(fileSize, that.fileSize)
                && Objects.equals(avatar, that.avatar)
                && Objects.equals(avatarThumbnail, that.avatarThumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fileSize, avatar, avatarThumbnail);
    }
}
