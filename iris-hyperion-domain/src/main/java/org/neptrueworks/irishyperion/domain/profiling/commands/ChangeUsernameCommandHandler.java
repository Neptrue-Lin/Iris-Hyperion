package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.profiling.UserOutline;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChangeUsernameCommandHandler extends CommandHandler<ChangeUsernameCommand> {
    private final UserOutlineRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, ChangeUsernameCommand command) {
        UserOutline outline = repository.fetchByIdentifierOrError(command.getUserId());
        outline.changeUsername(eventPublisher, command);
        repository.save(outline);
    }
}
