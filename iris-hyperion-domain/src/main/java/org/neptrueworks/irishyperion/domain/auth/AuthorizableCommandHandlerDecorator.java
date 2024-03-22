package org.neptrueworks.irishyperion.domain.auth;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthorizableCommandHandlerDecorator extends CommandHandler<AuthorizableCommandDecorator> {
    private CommandHandler<Command> handler;
    private AuthorizationService authorizationService;

    @Override
    public void handle(EventPublisher eventPublisher, AuthorizableCommandDecorator command) {
        boolean isAuthorized = authorizationService.authorize(command.getDecoratedCommand(), command.getIdentifier(),
                command.getCredential());
        if (!isAuthorized) {
            eventPublisher.publish(new AuthorizationFailedEvent(command.getIdentifier(), command.getCredential(),
                    eventPublisher.getChronographService().currentDateTime()));
            return;
        }
        eventPublisher.publish(new AuthorizationSucceededEvent(command.getIdentifier(), command.getCredential(),
                eventPublisher.getChronographService().currentDateTime()));
        this.handler.handle(eventPublisher, command.getDecoratedCommand());
    }
}
