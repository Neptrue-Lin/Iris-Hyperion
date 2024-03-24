package org.neptrueworks.irishyperion.application.security.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;

import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public class EmailAddress extends IdentificationClaim {
    private static final int EMAIL_ADDRESS_PART_TOTAL_COUNT = 2;
    private static final Pattern VALID_HOST_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9_-]*$");
    private static final Pattern VALID_DOMAIN_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9-]*$");
    private static final int HOST_PART_INDEX = 0;
    private static final int DOMAIN_PART_INDEX = 1;
    private static final int MAX_HOST_PART_LENGTH = 64;
    private static final int MAX_DOMAIN_PART_LENGTH = 255;
    private static final int MAX_DOMAIN_NAME_LENGTH = 64;
    private static final String EMAIL_SEPARATOR = "@";
    private static final String LEVEL_SEPARATOR = "\\.";
    private String claim;

    public static boolean isMatch(EmailAddress emailAddress) {
        if (emailAddress == null || emailAddress.getClaim() == null)
            throw new IllegalArgumentException();

        String[] emailAddressSplits = emailAddress.getClaim().split(EMAIL_SEPARATOR);

        if (emailAddressSplits.length != EMAIL_ADDRESS_PART_TOTAL_COUNT)
            return false;

        String hostPart = emailAddressSplits[HOST_PART_INDEX];
        String domainPart = emailAddressSplits[DOMAIN_PART_INDEX];

        return validateHostPart(hostPart) && validateDomainPart(domainPart);
    }

    private static boolean validateHostPart(String hostPart) {
        if (hostPart.length() > MAX_HOST_PART_LENGTH)
            return false;

        String[] hostNameSplits = hostPart.split(LEVEL_SEPARATOR);
        for (String hostNameSplit : hostNameSplits) {
            if (hostNameSplit.isEmpty())
                return false;
            if (!VALID_HOST_NAME_PATTERN.matcher(hostNameSplit).matches())
                return false;
        }
        return true;
    }


    private static boolean validateDomainPart(String domainPart) {
        if (domainPart.length() > MAX_DOMAIN_PART_LENGTH)
            return false;

        String[] domainNameSplits = domainPart.split(LEVEL_SEPARATOR);
        for (String domainNameSplit : domainNameSplits) {
            if (domainNameSplit.length() > MAX_DOMAIN_NAME_LENGTH
                    || domainNameSplit.isEmpty())
                return false;
            if (!VALID_DOMAIN_NAME_PATTERN.matcher(domainNameSplit).matches())
                return false;
        }
        return true;
    }
}
