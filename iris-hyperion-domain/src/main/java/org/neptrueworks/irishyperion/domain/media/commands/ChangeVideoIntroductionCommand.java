package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class ChangeVideoIntroductionCommand extends Command {
    private UserIdentifier author;
    private VideoProfileIdentifier video;
    private String introduction;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeVideoIntroductionCommand that = (ChangeVideoIntroductionCommand) o;
        return Objects.equals(author, that.author) && Objects.equals(video, that.video)
                && Objects.equals(introduction, that.introduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, video, introduction);
    }
}
