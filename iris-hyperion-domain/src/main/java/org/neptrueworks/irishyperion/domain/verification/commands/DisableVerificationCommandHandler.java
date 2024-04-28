package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DisableVerificationCommandHandler extends CommandHandler<DisableVerificationCommand> {
    private final UserVerityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DisableVerificationCommand command) {
        UserVerity userVerity = this.repository.fetchByIdentifierOrError(command.identifier());
        userVerity.disableVerification(eventPublisher, command);
        this.repository.save(userVerity);
    }
}
