package org.neptrueworks.irishyperion.domain.core;

import org.neptrueworks.irishyperion.domain.chrono.ChronographService;

public abstract class EventPublisher {
    public abstract void publish(DomainEvent event);
    public abstract ChronographService getChronographService();
}
