package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveIdentityCommandHandler extends CommandHandler<RemoveIdentityCommand> {
    private final UserIdentityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, RemoveIdentityCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.getIdentifier());
        userIdentity.removeUserIdentity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
