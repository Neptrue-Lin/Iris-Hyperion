package org.neptrueworks.irishyperion.domain.core;

public abstract class EventListener<TDomainEvent extends DomainEvent> {
    public abstract void on(TDomainEvent event);
}
