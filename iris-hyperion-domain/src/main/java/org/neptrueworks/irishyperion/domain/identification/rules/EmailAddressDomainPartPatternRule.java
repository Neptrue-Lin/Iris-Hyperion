package org.neptrueworks.irishyperion.domain.identification.rules;

import org.neptrueworks.irishyperion.domain.identification.exceptions.EmailAddressDomainNameEmptyException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.EmailAddressDomainPartLevelExceededException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.EmailAddressDomainPartOverlengthException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.InvalidEmailAddressDomainNameException;

import java.util.regex.Pattern;

import static org.neptrueworks.irishyperion.domain.identification.EmailAddress.LEVEL_SEPARATOR;

public class EmailAddressDomainPartPatternRule extends ClaimPatternRule {
    private static final Pattern VALID_DOMAIN_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9-]*[A-z0-9]?$");
    private static final int MAX_DOMAIN_PART_LENGTH = 255;
    private static final int MAX_DOMAIN_NAME_LENGTH = 63;
    public static final int MAX_DOMAIN_NAME_LEVEL = 3;

    private final int maxDomainPartLength;
    private final int maxDomainNameLength;

    public EmailAddressDomainPartPatternRule(int maxDomainPartLength, int maxDomainNameLength) {
        this.maxDomainPartLength = Math.min(MAX_DOMAIN_PART_LENGTH, maxDomainPartLength);
        this.maxDomainNameLength = Math.min(MAX_DOMAIN_NAME_LENGTH, maxDomainNameLength);
    }

    @Override
    public void apply(String domainPart) {
        if (domainPart.length() > this.maxDomainPartLength)
            throw new EmailAddressDomainPartOverlengthException();

        String[] domainNameSplits = domainPart.split(LEVEL_SEPARATOR);

        if (domainNameSplits.length > MAX_DOMAIN_NAME_LEVEL)
            throw new EmailAddressDomainPartLevelExceededException();

        for (String domainNameSplit : domainNameSplits) {
            if (domainNameSplit.length() > this.maxDomainNameLength)
                throw new EmailAddressDomainPartOverlengthException();
            if (domainNameSplit.isEmpty())
                throw new EmailAddressDomainNameEmptyException();
            if (!VALID_DOMAIN_NAME_PATTERN.matcher(domainNameSplit).matches())
                throw new InvalidEmailAddressDomainNameException();
        }
    }
}
