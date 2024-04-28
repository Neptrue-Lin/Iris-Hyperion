package org.neptrueworks.irishyperion.domain.common;

import java.io.Serializable;

public interface AggregateIdentifier<TComparable extends Comparable<TComparable>>
        extends Serializable {
    TComparable identifier();
}
