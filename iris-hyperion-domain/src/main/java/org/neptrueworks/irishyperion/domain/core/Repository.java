package org.neptrueworks.irishyperion.domain.core;

public abstract class Repository<TAggregateRoot extends AggregateRoot> {
    public abstract void save(TAggregateRoot aggregateRoot);
}
