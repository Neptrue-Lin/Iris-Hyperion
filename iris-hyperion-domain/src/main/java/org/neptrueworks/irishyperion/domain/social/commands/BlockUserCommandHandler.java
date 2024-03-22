package org.neptrueworks.irishyperion.domain.social.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.social.SocialEngagement;
import org.neptrueworks.irishyperion.domain.social.SocialEngagementRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BlockUserCommandHandler extends CommandHandler<BlockUserCommand> {
    private SocialEngagementRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, BlockUserCommand command) {
        SocialEngagement socialEngagement = this.repository.fetchByIdentifierOrError(
                command.getBlockedBy(), command.getBlockedUser());
        socialEngagement.blockUser(eventPublisher, command);
        this.repository.save(socialEngagement);
    }
}
