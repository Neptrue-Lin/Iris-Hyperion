package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.profiling.UserOutline;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChangeAvatarCommandHandler extends CommandHandler<ChangeAvatarCommand> {
    private final UserOutlineRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, ChangeAvatarCommand command) {
        UserOutline outline = repository.fetchByIdentifierOrError(command.userId());
        outline.changeAvatar(eventPublisher, command);
        repository.save(outline);
    }
}
