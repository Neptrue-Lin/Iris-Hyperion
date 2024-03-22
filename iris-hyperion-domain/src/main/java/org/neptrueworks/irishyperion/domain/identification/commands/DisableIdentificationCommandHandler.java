package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DisableIdentificationCommandHandler extends CommandHandler<DisableIdentificationCommand> {
    private UserIdentityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DisableIdentificationCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.getIdentifier());
        userIdentity.disableIdentification(eventPublisher,command);
        this.repository.save(userIdentity);
    }
}
