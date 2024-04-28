package org.neptrueworks.irishyperion.domain.media;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.TopicTagIdentifier;
import org.neptrueworks.irishyperion.domain.media.commands.*;
import org.neptrueworks.irishyperion.domain.media.events.*;

import java.net.URI;
import java.util.Collection;

@Getter
@AllArgsConstructor
@Builder
public class VideoProfile extends AggregateRoot {
    private VideoProfileIdentifier videoProfileId;
    private UserIdentifier author;
    private String title;
    private URI cover;
    private Collection<TopicTagIdentifier> tags;
    private String description;
    private Collection<UserIdentifier> creators;
    private URI content;
    private boolean isPublished;
    private boolean isDeleted;

    public void publishVideo(EventPublisher eventPublisher, PublishVideoCommand command) {
        if (this.isPublished())
            return;
        this.isPublished = true;
        eventPublisher.publish(new VideoPublishedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void removeVideo(EventPublisher eventPublisher, RemoveVideoCommand command) {
        if (this.isDeleted())
            return;
        this.isDeleted = true;
        eventPublisher.publish(new VideoRemovedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeTitle(EventPublisher eventPublisher, ChangeVideoTitleCommand command) {
        this.title = command.title();
        eventPublisher.publish(new VideoTitleChangedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeCover(EventPublisher eventPublisher, ChangeVideoCoverCommand command) {
        this.cover = command.cover();
        eventPublisher.publish(new VideoCoverChangedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeDescription(EventPublisher eventPublisher, ChangeVideoDescriptionCommand command) {
        this.description = command.description();
        eventPublisher.publish(new VideoIntroductionChangedEvent(this.getVideoProfileId(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void addCreator(EventPublisher eventPublisher, AddVideoCreatorCommand command) {
        if (this.getCreators().contains(command.creator()))
            return;
        this.creators.add(command.creator());
        eventPublisher.publish(new VideoCreatorAddedEvent(this.getVideoProfileId(), this.getAuthor(),
                command.author(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void removeCreator(EventPublisher eventPublisher, RemoveVideoCreatorCommand command) {
        if (!this.getCreators().contains(command.creator()))
            return;
        this.creators.remove(command.creator());
        eventPublisher.publish(new VideoCreatorRemovedEvent(this.getVideoProfileId(), command.creator(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void attachTag(EventPublisher eventPublisher, AttachVideoTagCommand command) {
        if (this.getTags().contains(command.tag()))
            return;
        this.tags.add(command.tag());
        eventPublisher.publish(new VideoTagAttachedEvent(this.getVideoProfileId(), command.tag(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void detachTag(EventPublisher eventPublisher, DetachVideoTagCommand command) {
        if (!this.getTags().contains(command.tag()))
            return;
        this.tags.remove(command.tag());
        eventPublisher.publish(new VideoTagDetachedEvent(this.getVideoProfileId(), command.tag(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }
}
