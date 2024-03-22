package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class ChangeVideoTitleCommand extends Command {
    private UserIdentifier author;
    private VideoProfileIdentifier video;
    private String title;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeVideoTitleCommand that = (ChangeVideoTitleCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, title);
    }
}
