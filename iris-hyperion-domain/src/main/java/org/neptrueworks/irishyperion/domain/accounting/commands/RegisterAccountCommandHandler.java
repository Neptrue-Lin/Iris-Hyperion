package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserFacadeFactory;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterAccountCommandHandler extends CommandHandler<RegisterAccountCommand> {
    private UserFacadeFactory userFacadeFactory;

    @Override
    public void handle(EventPublisher eventPublisher, RegisterAccountCommand command) {
        this.userFacadeFactory.create(eventPublisher, command.getIdentificationClaim(),
                command.getVerificationCredential(), command.getUsername());
    }
}
