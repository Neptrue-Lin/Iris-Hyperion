package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

@AllArgsConstructor
@Getter
public class UserIdentifier extends AggregateIdentifier<String> {
    private final String identifier;
}
