package org.neptrueworks.irishyperion.domain.interaction;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record TopicTagIdentifier(String identifier) implements AggregateIdentifier<String> {
}
