package org.neptrueworks.irishyperion.domain.identification.rules;

import org.neptrueworks.irishyperion.domain.identification.exceptions.EmailAddressHostPartOverLengthException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.EmptyEmailAddressHostNameException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.InvalidEmailAddressHostNameException;

import java.util.regex.Pattern;

import static org.neptrueworks.irishyperion.domain.identification.EmailAddress.LEVEL_SEPARATOR;

public class EmailAddressHostPartPatternRule extends ClaimPatternRule {
    private static final Pattern VALID_HOST_NAME_PATTERN = Pattern.compile("^[A-z0-9][A-z0-9_-]*[A-z0-9]?$");
    private static final int MAX_HOST_PART_LENGTH = 64;

    private final int maxHostPartLength;

    public EmailAddressHostPartPatternRule(int maxHostPartLength) {
        this.maxHostPartLength = Math.min(maxHostPartLength, MAX_HOST_PART_LENGTH);
    }

    @Override
    public void apply(String hostPart) {
        if (hostPart.length() > this.maxHostPartLength)
            throw new EmailAddressHostPartOverLengthException(this.maxHostPartLength);

        String[] hostNameSplits = hostPart.split(LEVEL_SEPARATOR);
        for (String hostNameSplit : hostNameSplits) {
            if (hostNameSplit.isEmpty())
                throw new EmptyEmailAddressHostNameException();
            if (!VALID_HOST_NAME_PATTERN.matcher(hostNameSplit).matches())
                throw new InvalidEmailAddressHostNameException();
        }
    }
}
