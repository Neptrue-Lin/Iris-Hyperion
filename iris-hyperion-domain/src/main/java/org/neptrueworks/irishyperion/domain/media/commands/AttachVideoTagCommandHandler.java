package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AttachVideoTagCommandHandler extends CommandHandler<AttachVideoTagCommand> {
    private final VideoProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, AttachVideoTagCommand command) {
        VideoProfile videoProfile = this.repository.fetchByIdentifierOrError(command.video());
        if (videoProfile.getTags().contains(command.tag()))
            return;
        videoProfile.attachTag(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
