package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResetCredentialCommandHandler extends CommandHandler<ResetCredentialCommand> {
    private UserVerityRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, ResetCredentialCommand command) {
        UserVerity userVerity = this.repository.fetchByIdentifierOrError(command.getIdentifier());
        userVerity.resetCredential(eventPublisher, command);
        this.repository.save(userVerity);
    }
}
