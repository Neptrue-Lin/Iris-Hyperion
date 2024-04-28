package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LockVerityCommandHandler extends CommandHandler<LockVerityCommand> {
    private final UserVerityRepository repository;

    public void handle(EventPublisher eventPublisher, LockVerityCommand command) {
        UserVerity userIdentity = this.repository.fetchByIdentifierOrError(command.identifier());
        userIdentity.lockUserVerity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
