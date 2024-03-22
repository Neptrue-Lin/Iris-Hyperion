package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnableVerificationCommandHandler extends CommandHandler<EnableVerificationCommand> {
    private UserIdentityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, EnableVerificationCommand command) {
        UserIdentity userIdentity = this.repository.fetchByIdentifierOrError(command.getIdentifier());
        userIdentity.enableVerification(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
