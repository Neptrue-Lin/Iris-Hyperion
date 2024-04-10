package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityFactory;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddIdentityCommandHandler extends CommandHandler<AddIdentityCommand> {
    private final UserIdentityRepository repository;
    private final UserIdentityFactory userIdentityFactory;

    @Override
    public void handle(EventPublisher eventPublisher, AddIdentityCommand command) {
        UserIdentity userIdentity = this.userIdentityFactory.create(eventPublisher, command.getUserId(),
                command.getIdentificationClaim());
        this.repository.save(userIdentity);
    }
}
