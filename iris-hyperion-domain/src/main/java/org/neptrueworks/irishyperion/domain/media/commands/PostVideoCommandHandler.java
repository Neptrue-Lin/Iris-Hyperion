package org.neptrueworks.irishyperion.domain.media.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.media.VideoProfile;
import org.neptrueworks.irishyperion.domain.media.VideoProfileFactory;
import org.neptrueworks.irishyperion.domain.media.VideoProfileRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostVideoCommandHandler extends CommandHandler<PostVideoCommand> {
    private final VideoProfileRepository repository;
    private final VideoProfileFactory videoProfileFactory;

    @Override
    public void handle(EventPublisher eventPublisher, PostVideoCommand command) {
        VideoProfile videoProfile = this.videoProfileFactory.create(eventPublisher, command);
        this.repository.save(videoProfile);
    }
}
