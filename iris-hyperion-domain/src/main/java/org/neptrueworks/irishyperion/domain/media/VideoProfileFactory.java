package org.neptrueworks.irishyperion.domain.media;

import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.commands.PostVideoCommand;

public abstract class VideoProfileFactory {
    public abstract VideoProfile create(EventPublisher eventPublisher, PostVideoCommand command);
}
