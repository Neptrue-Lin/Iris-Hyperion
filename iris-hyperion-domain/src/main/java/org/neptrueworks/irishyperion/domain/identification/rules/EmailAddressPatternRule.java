package org.neptrueworks.irishyperion.domain.identification.rules;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.exceptions.InvalidEmailAddressTotalPartException;
import org.springframework.stereotype.Component;

import static org.neptrueworks.irishyperion.domain.identification.EmailAddress.EMAIL_SEPARATOR;

@Component
@AllArgsConstructor
public class EmailAddressPatternRule extends ClaimPatternRule{
    private static final int EMAIL_ADDRESS_PART_TOTAL_COUNT = 2;
    private static final int HOST_PART_INDEX = 0;
    private static final int DOMAIN_PART_INDEX = 1;

    private final EmailAddressDomainPartPatternRule domainPartPatternRule;
    private final EmailAddressHostPartPatternRule hostPartPatternRule;

    @Override
    public void apply(String emailAddress) {
        String[] emailAddressSplits = emailAddress.split(EMAIL_SEPARATOR);

        if (emailAddressSplits.length != EMAIL_ADDRESS_PART_TOTAL_COUNT)
            throw new InvalidEmailAddressTotalPartException();

        String hostPart = emailAddressSplits[HOST_PART_INDEX];
        String domainPart = emailAddressSplits[DOMAIN_PART_INDEX];
        this.hostPartPatternRule.apply(hostPart);
        this.domainPartPatternRule.apply(domainPart);
    }
}
