package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LockIdentityCommandHandler extends CommandHandler<LockIdentityCommand> {
    private final UserIdentityRepository repository;

    public void handle(EventPublisher eventPublisher, LockIdentityCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.getIdentityIdentifier());
        userIdentity.lockUserIdentity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
