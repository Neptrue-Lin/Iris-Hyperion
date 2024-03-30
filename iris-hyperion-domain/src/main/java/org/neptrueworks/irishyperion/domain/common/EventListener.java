package org.neptrueworks.irishyperion.domain.common;

public abstract class EventListener<TDomainEvent extends DomainEvent> {
    public abstract void on(TDomainEvent event);
}
