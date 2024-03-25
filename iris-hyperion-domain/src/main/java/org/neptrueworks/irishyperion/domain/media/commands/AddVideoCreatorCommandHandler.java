package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddVideoCreatorCommandHandler extends CommandHandler<AddVideoCreatorCommand> {
    private final VideoProfileRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, AddVideoCreatorCommand command) {
        VideoProfile videoProfile = this.repository.fetchByIdentifierOrError(command.getVideo());
        videoProfile.addCreator(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
