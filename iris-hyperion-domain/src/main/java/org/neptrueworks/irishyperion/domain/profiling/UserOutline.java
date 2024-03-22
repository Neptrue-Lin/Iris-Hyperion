package org.neptrueworks.irishyperion.domain.profiling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.profiling.commands.ChangeAvatarCommand;
import org.neptrueworks.irishyperion.domain.profiling.commands.ChangeUsernameCommand;
import org.neptrueworks.irishyperion.domain.profiling.events.AvatarChangedEvent;
import org.neptrueworks.irishyperion.domain.profiling.events.UsernameChangedEvent;

import java.net.URI;

@Getter
@AllArgsConstructor
@Builder
public class UserOutline extends AggregateRoot {
    private UserIdentifier userId;
    private String username;
    private URI avatarURI;
    private String avatarThumbnail;
    private boolean isDeleted;

    public void changeAvatar(EventPublisher eventPublisher, ChangeAvatarCommand command) {
        this.avatarURI = command.getAvatar();
        this.avatarThumbnail = command.getAvatarThumbnail();

        eventPublisher.publish(new AvatarChangedEvent(this.getAvatarThumbnail(), this.getAvatarURI(),
                this.getUserId(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeUsername(EventPublisher eventPublisher, ChangeUsernameCommand command) {
        this.username = command.getUsername();
        eventPublisher.publish(new UsernameChangedEvent(this.getUsername(), this.getUserId(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
