package org.neptrueworks.irishyperion.domain.media;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record VideoCategoryIdentifier(String identifier) implements AggregateIdentifier<String> {
}
