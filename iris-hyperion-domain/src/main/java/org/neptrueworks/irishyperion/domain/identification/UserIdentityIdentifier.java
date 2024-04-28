package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record UserIdentityIdentifier(String identifier) implements AggregateIdentifier<String> {
}
