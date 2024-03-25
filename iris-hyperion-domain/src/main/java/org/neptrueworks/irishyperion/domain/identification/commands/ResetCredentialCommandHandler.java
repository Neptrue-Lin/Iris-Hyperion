package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.services.IdentificationService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResetCredentialCommandHandler extends CommandHandler<ResetCredentialCommand> {
    private final UserIdentityRepository repository;
    private final IdentificationService identificationService;

    @Override
    public void handle(EventPublisher eventPublisher, ResetCredentialCommand command) {
        UserIdentity userIdentity = this.identificationService.identify(command.getIdentifier());
        userIdentity.resetCredential(eventPublisher, command);
        this.repository.save(userIdentity);
    }
}
