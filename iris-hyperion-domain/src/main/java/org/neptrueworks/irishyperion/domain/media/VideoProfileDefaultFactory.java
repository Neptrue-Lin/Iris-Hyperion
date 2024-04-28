package org.neptrueworks.irishyperion.domain.media;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.common.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.media.commands.PostVideoCommand;
import org.neptrueworks.irishyperion.domain.media.events.VideoPostedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VideoProfileDefaultFactory extends VideoProfileFactory {
    private IIdentifierGeneratable<VideoProfileIdentifier> identifierGenerator;

    @Override
    public VideoProfile create(EventPublisher eventPublisher, PostVideoCommand command) {
        VideoProfile videoProfile = VideoProfile.builder()
                .videoProfileId(this.identifierGenerator.nextIdentifier())
                .author(command.author())
                .title(command.title())
                .cover(command.cover())
                .tags(command.tags())
                .description(command.description())
                .creators(command.creators())
                .content(command.content())
                .build();
        eventPublisher.publish(new VideoPostedEvent(videoProfile.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
        return videoProfile;
    }
}
