package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.media.VideoProfileIdentifier;

import java.net.URI;

@Getter
@AllArgsConstructor
public class ChangeVideoCoverCommand extends Command {
    private final UserIdentifier author;
    private final VideoProfileIdentifier video;
    private final URI cover;
}
