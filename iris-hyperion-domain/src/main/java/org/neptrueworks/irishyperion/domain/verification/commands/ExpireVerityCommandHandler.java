package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpireVerityCommandHandler extends CommandHandler<ExpireVerityCommand> {
    private final UserVerityRepository repository;

    public void handle(EventPublisher eventPublisher, ExpireVerityCommand command) {
        UserVerity userVerity = this.repository.fetchByIdentityIdentifierOrError(command.getIdentityIdentifier());
        userVerity.expireUserVerity(eventPublisher, command);
        this.repository.save(userVerity);
    }
}
