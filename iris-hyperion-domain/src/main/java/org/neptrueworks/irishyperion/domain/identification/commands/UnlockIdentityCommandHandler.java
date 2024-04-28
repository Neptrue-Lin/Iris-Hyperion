package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnlockIdentityCommandHandler extends CommandHandler<UnlockIdentityCommand> {
    private final UserIdentityRepository repository;

    public void handle(EventPublisher eventPublisher, UnlockIdentityCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.identityIdentifier());
        userIdentity.unlockUserIdentity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
