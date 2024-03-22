package org.neptrueworks.irishyperion.domain.media;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
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
    private String introduction;
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
        this.title = command.getTitle();
        eventPublisher.publish(new VideoTitleChangedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeCover(EventPublisher eventPublisher, ChangeVideoCoverCommand command) {
        this.cover = command.getCover();
        eventPublisher.publish(new VideoCoverChangedEvent(this.getVideoProfileId(), this.getAuthor(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeIntroduction(EventPublisher eventPublisher, ChangeVideoIntroductionCommand command) {
        this.introduction = command.getIntroduction();
        eventPublisher.publish(new VideoIntroductionChangedEvent(this.getVideoProfileId(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void addCreator(EventPublisher eventPublisher, AddVideoCreatorCommand command) {
        if (this.getCreators().contains(command.getCreator()))
            return;
        this.creators.add(command.getCreator());
        eventPublisher.publish(new VideoCreatorAddedEvent(this.getVideoProfileId(), this.getAuthor(),
                command.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void removeCreator(EventPublisher eventPublisher, RemoveVideoCreatorCommand command) {
        if (!this.getCreators().contains(command.getCreator()))
            return;
        this.creators.remove(command.getCreator());
        eventPublisher.publish(new VideoCreatorRemovedEvent(this.getVideoProfileId(), command.getCreator(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void attachTag(EventPublisher eventPublisher, AttachVideoTagCommand command) {
        if (this.getTags().contains(command.getTag()))
            return;
        this.tags.add(command.getTag());
        eventPublisher.publish(new VideoTagAttachedEvent(this.getVideoProfileId(), command.getTag(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void detachTag(EventPublisher eventPublisher, DetachVideoTagCommand command) {
        if (!this.getTags().contains(command.getTag()))
            return;
        this.tags.remove(command.getTag());
        eventPublisher.publish(new VideoTagDetachedEvent(this.getVideoProfileId(), command.getTag(),
                this.getAuthor(), eventPublisher.getChronographService().currentDateTime()));
    }
}
