package org.neptrueworks.irishyperion.domain.common;

public interface IIdentifierGeneratable<TAggregateIdentifier extends AggregateIdentifier<?>> {
    TAggregateIdentifier nextIdentifier();
}
