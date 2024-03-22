package org.neptrueworks.irishyperion.domain.social;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.social.commands.BlockUserCommand;
import org.neptrueworks.irishyperion.domain.social.commands.FollowUserCommand;
import org.neptrueworks.irishyperion.domain.social.commands.UnblockUserCommand;
import org.neptrueworks.irishyperion.domain.social.commands.UnfollowUserCommand;
import org.neptrueworks.irishyperion.domain.social.events.UserBlockedEvent;
import org.neptrueworks.irishyperion.domain.social.events.UserFollowedEvent;
import org.neptrueworks.irishyperion.domain.social.events.UserUnblockedEvent;
import org.neptrueworks.irishyperion.domain.social.events.UserUnfollowedEvent;

@Getter
@AllArgsConstructor
public class SocialEngagement extends AggregateRoot {
    private UserIdentifier source;
    private UserIdentifier target;
    private boolean isFollowed;
    private boolean isBlocked;

    public void followUser(EventPublisher eventPublisher, FollowUserCommand command) {
        if (this.isFollowed())
            return;
        this.isFollowed = true;
        eventPublisher.publish(new UserFollowedEvent(this.getSource(), this.getTarget(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void unfollowUser(EventPublisher eventPublisher, UnfollowUserCommand command) {
        if (!this.isFollowed())
            return;
        this.isFollowed = false;
        eventPublisher.publish(new UserUnfollowedEvent(this.getSource(), this.getTarget(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void blockUser(EventPublisher eventPublisher, BlockUserCommand command) {
        if (this.isBlocked())
            return;
        this.isBlocked = true;
        eventPublisher.publish(new UserBlockedEvent(this.getSource(), this.getTarget(), eventPublisher.getChronographService().currentDateTime()));
    }

    public void unblockUser(EventPublisher eventPublisher, UnblockUserCommand command) {
        if (!this.isBlocked())
            return;
        this.isBlocked = false;
        eventPublisher.publish(new UserUnblockedEvent(this.getSource(), this.getTarget(), eventPublisher.getChronographService().currentDateTime()));
    }
}