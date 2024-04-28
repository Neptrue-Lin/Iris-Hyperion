package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnableIdentificationCommandHandler extends CommandHandler<EnableIdentificationCommand> {
    private final UserIdentityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, EnableIdentificationCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.identifier());
        userIdentity.enableIdentification(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
