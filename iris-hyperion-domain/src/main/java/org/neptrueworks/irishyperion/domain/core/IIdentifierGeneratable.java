package org.neptrueworks.irishyperion.domain.core;

public interface IIdentifierGeneratable<TAggregateIdentifier extends AggregateIdentifier<?>> {
    TAggregateIdentifier nextIdentifier();
}
