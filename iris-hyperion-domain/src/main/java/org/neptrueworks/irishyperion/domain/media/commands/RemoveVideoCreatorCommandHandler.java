package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveVideoCreatorCommandHandler extends CommandHandler<RemoveVideoCreatorCommand> {
    private VideoProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, RemoveVideoCreatorCommand command) {
        VideoProfile videoProfile = this.repository.fetchByIdentifierOrError(command.getVideo());
        videoProfile.removeCreator(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
