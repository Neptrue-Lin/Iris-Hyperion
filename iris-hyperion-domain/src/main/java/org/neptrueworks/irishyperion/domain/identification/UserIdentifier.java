package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record UserIdentifier(String identifier) implements AggregateIdentifier<String> {
}
