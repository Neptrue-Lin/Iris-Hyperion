package org.neptrueworks.irishyperion.domain.common;

public abstract class Repository<TAggregateRoot extends AggregateRoot> {
    public abstract void save(TAggregateRoot aggregateRoot);
}
