package org.neptrueworks.irishyperion.domain.profiling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
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
    private short level;
    private boolean isDeleted;

    public void changeAvatar(EventPublisher eventPublisher, ChangeAvatarCommand command) {
        this.avatarURI = command.avatar();

        eventPublisher.publish(new AvatarChangedEvent(this.getAvatarURI(),
                this.getUserId(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void changeUsername(EventPublisher eventPublisher, ChangeUsernameCommand command) {
        this.username = command.username();
        eventPublisher.publish(new UsernameChangedEvent(this.getUsername(), this.getUserId(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
