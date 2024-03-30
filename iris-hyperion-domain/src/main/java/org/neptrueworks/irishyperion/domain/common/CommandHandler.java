package org.neptrueworks.irishyperion.domain.common;

public abstract class CommandHandler<TCommand extends Command> extends DomainService {
    public abstract void handle(EventPublisher eventPublisher, TCommand command);
}