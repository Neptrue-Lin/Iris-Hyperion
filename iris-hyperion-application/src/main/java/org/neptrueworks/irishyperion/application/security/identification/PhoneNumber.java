package org.neptrueworks.irishyperion.application.security.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;

@AllArgsConstructor
public class PhoneNumber extends IdentificationClaim {
    private static final String PHONE_NUMBER_PREFIX = "1";
    private static final int PHONE_NUMBER_LENGTH = 11;
    private static final int PHONE_NUMBER_SECOND_DIGIT_INDEX = 1;
    private static final char PHONE_NUMBER_SECOND_DIGIT_LOWER_BOUND = '2';

    @Getter
    private String claim;

    public static boolean isMatch(PhoneNumber phoneNumber) {
        if (phoneNumber == null || phoneNumber.getClaim() == null)
            throw new IllegalArgumentException();

        if (!StringUtils.isNumeric(phoneNumber.getClaim()))
            return false;
        if (phoneNumber.getClaim().length() != PHONE_NUMBER_LENGTH)
            return false;

        if (!phoneNumber.getClaim().startsWith(PHONE_NUMBER_PREFIX))
            return false;
        if (phoneNumber.getClaim().charAt(PHONE_NUMBER_SECOND_DIGIT_INDEX)
                > PHONE_NUMBER_SECOND_DIGIT_LOWER_BOUND)
            return false;
        return true;
    }
}
