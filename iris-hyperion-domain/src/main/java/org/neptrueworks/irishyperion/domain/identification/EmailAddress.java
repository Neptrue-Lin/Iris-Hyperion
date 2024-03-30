package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.exceptions.InvalidEmailAddressFormatException;

import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public class EmailAddress extends IdentificationClaim {
    private static final int EMAIL_ADDRESS_PART_TOTAL_COUNT = 2;
    private static final Pattern VALID_HOST_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9_-]*[A-z0-9]?$");
    private static final Pattern VALID_DOMAIN_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9-]*[A-z0-9]?$");
    private static final int HOST_PART_INDEX = 0;
    private static final int DOMAIN_PART_INDEX = 1;
    private static final int MAX_HOST_PART_LENGTH = 64;
    private static final int MAX_DOMAIN_PART_LENGTH = 255;
    private static final int MAX_DOMAIN_NAME_LENGTH = 63;
    private static final String EMAIL_SEPARATOR = "@";
    private static final String LEVEL_SEPARATOR = "\\.";
    private String claim;

    public static EmailAddress match(String emailAddress) {
        if (!EmailAddress.isMatch(emailAddress))
            throw new InvalidEmailAddressFormatException();

        return new EmailAddress(emailAddress);
    }

    public static boolean isMatch(String emailAddress) {
        if (emailAddress == null)
            throw new NullPointerException();

        String[] emailAddressSplits = emailAddress.split(EMAIL_SEPARATOR);

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

        //The level of domain should not be over 2nd.
        if(domainNameSplits.length > 3)
            return false;

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
