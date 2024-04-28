package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveVideoCommandHandler extends CommandHandler<RemoveVideoCommand> {
    private final VideoProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, RemoveVideoCommand command) {
        VideoProfile videoProfile = this.repository.fetchByIdentifierOrError(command.video());
        videoProfile.removeVideo(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
