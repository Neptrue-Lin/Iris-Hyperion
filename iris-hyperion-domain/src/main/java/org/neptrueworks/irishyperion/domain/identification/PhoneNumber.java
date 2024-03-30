package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.exceptions.InvalidPhoneNumberFormatException;

import java.util.Locale;

@AllArgsConstructor
@Getter
public class PhoneNumber extends IdentificationClaim {
    private static final String PHONE_NUMBER_PREFIX = "1";
    private static final int PHONE_NUMBER_LENGTH = 11;
    private static final int PHONE_NUMBER_SECOND_DIGIT_INDEX = 1;
    private static final char PHONE_NUMBER_SECOND_DIGIT_LOWER_BOUND = '2';
    private String claim;
    private Locale countryCode;
    private TelephoneNumberAreaCode areaCode;

    public static PhoneNumber match(String phoneNumber, Locale countryCode,
                                    TelephoneNumberAreaCode areaCode) {
        if (!PhoneNumber.isMatch(phoneNumber))
            throw new InvalidPhoneNumberFormatException();

        return new PhoneNumber(phoneNumber, countryCode, areaCode);
    }

    public static boolean isMatch(String phoneNumber) {
        if (phoneNumber == null)
            throw new NullPointerException();

        try {
            Integer.parseUnsignedInt(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        if (phoneNumber.length() != PHONE_NUMBER_LENGTH)
            return false;

        if (!phoneNumber.startsWith(PHONE_NUMBER_PREFIX))
            return false;
        return phoneNumber.charAt(PHONE_NUMBER_SECOND_DIGIT_INDEX) <= PHONE_NUMBER_SECOND_DIGIT_LOWER_BOUND;
    }
}
