package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvalidateCredentialCommandHandler extends CommandHandler<InvalidateCredentialCommand> {
    @Override
    public void handle(EventPublisher eventPublisher, InvalidateCredentialCommand command) {

    }
}
