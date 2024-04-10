package org.neptrueworks.irishyperion.domain.identification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.rules.EmailAddressPatternRule;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailAddressPatternRestriction extends ClaimPatternRestriction{
    private final EmailAddressPatternRule patternRule;

    @Override
    public void restrict(String emailAddress) {
        this.patternRule.apply(emailAddress);
    }
}
