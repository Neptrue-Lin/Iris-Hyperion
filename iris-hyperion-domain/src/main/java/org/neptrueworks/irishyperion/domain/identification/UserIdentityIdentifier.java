package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

@Getter
@AllArgsConstructor
public class UserIdentityIdentifier extends AggregateIdentifier<String> {
    private String identifier;
}
