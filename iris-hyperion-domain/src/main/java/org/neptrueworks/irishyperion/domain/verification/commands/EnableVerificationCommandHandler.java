package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnableVerificationCommandHandler extends CommandHandler<EnableVerificationCommand> {
    private final UserVerityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, EnableVerificationCommand command) {
        UserVerity userVerity = this.repository.fetchByIdentifierOrError(command.identifier());
        userVerity.enableVerification(eventPublisher, command);
        this.repository.save(userVerity);
    }
}
