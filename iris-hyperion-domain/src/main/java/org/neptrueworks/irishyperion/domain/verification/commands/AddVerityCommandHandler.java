package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityFactory;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddVerityCommandHandler extends CommandHandler<AddVerityCommand> {
    private final UserVerityRepository repository;
    private final UserVerityFactory userVerityFactory;

    @Override
    public void handle(EventPublisher eventPublisher, AddVerityCommand command) {
        UserVerity userVerity = this.userVerityFactory.create(eventPublisher, command.userId(),
                command.userIdentityIdentifier(), command.verificationCredential());
        this.repository.save(userVerity);
    }
}
