package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.social.SocialEngagement;
import org.neptrueworks.irishyperion.domain.social.SocialEngagementRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FollowUserCommandHandler extends CommandHandler<FollowUserCommand> {
    private final SocialEngagementRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, FollowUserCommand command) {
        SocialEngagement socialEngagement = this.repository.fetchByIdentifierOrError(command.getFollower(),
                command.getFollowee());
        socialEngagement.followUser(eventPublisher, command);
        this.repository.save(socialEngagement);
    }
}
