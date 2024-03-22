package org.neptrueworks.irishyperion.domain.core;

import java.io.Serializable;

public abstract class AggregateIdentifier<TComparable extends Comparable<TComparable>>
        implements Serializable {
    public abstract TComparable getIdentifier();
}
