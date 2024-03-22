package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;

import java.net.URI;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ChangeAvatarCommand extends Command {
    private Integer userId;
    private Integer fileSize;
    private URI avatar;
    private String avatarThumbnail;

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
