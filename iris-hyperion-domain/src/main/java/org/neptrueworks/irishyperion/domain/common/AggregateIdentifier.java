package org.neptrueworks.irishyperion.domain.common;

import java.io.Serializable;

public abstract class AggregateIdentifier<TComparable extends Comparable<TComparable>>
        implements Serializable {
    public abstract TComparable getIdentifier();
}
