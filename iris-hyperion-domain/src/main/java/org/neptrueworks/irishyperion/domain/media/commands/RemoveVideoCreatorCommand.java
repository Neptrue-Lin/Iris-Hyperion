package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

@Getter
@AllArgsConstructor
public class RemoveVideoCreatorCommand extends Command {
    private final UserIdentifier author;
    private final VideoProfileIdentifier video;
    private final UserIdentifier creator;
}
