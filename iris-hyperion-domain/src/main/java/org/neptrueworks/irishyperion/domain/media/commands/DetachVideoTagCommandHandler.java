package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DetachVideoTagCommandHandler extends CommandHandler<DetachVideoTagCommand> {
    private final VideoProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DetachVideoTagCommand command) {
        VideoProfile videoProfile = this.repository.fetchByIdentifierOrError(command.video());
        videoProfile.detachTag(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
