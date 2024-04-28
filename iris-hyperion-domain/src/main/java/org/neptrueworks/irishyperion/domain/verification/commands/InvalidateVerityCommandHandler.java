package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvalidateVerityCommandHandler extends CommandHandler<InvalidateVerityCommand> {
    private final UserVerityRepository repository;

    public void handle(EventPublisher eventPublisher, InvalidateVerityCommand command) {
        UserVerity userIdentity = this.repository.fetchByIdentifierOrError(command.identifier());
        userIdentity.invalidateUserVerity(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
