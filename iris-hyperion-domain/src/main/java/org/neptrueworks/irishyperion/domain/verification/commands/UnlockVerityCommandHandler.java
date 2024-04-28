package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnlockVerityCommandHandler extends CommandHandler<UnlockVerityCommand> {
    private final UserVerityRepository repository;

    public void handle(EventPublisher eventPublisher, UnlockVerityCommand command) {
        UserVerity userVerity = this.repository.fetchByIdentityIdentifierOrError(command.identityIdentifier());
        userVerity.unlockUserVerity(eventPublisher, command);
        this.repository.save(userVerity);
    }
}
