package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.social.SocialEngagement;
import org.neptrueworks.irishyperion.domain.social.SocialEngagementRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnfollowUserCommandHandler extends CommandHandler<UnfollowUserCommand> {
    private final SocialEngagementRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, UnfollowUserCommand command) {
        SocialEngagement socialEngagement = this.repository.fetchByIdentifierOrError(
                command.getUnfollower(), command.getUnfollowee());
        socialEngagement.unfollowUser(eventPublisher, command);
        this.repository.save(socialEngagement);
    }
}
