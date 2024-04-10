package org.neptrueworks.irishyperion.domain.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateIdentifier;

@Getter
@AllArgsConstructor
public class UserVerityIdentifier extends AggregateIdentifier<String> {
    private String identifier;
}
