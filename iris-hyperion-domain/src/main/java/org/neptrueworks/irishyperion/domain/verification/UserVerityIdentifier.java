package org.neptrueworks.irishyperion.domain.verification;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record UserVerityIdentifier(String identifier) implements AggregateIdentifier<String> {
}
