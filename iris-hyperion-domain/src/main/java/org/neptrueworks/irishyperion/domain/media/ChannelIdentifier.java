package org.neptrueworks.irishyperion.domain.media;

import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

public record ChannelIdentifier(String identifier) implements AggregateIdentifier<String> {
}
