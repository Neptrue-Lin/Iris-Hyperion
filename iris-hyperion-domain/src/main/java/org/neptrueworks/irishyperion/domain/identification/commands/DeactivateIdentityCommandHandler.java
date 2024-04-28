package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeactivateIdentityCommandHandler extends CommandHandler<DeactivateIdentityCommand> {
    private final UserIdentityRepository repository;

    public void handle(EventPublisher eventPublisher, DeactivateIdentityCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.identityIdentifier());
        userIdentity.deactivateUserIdentity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
