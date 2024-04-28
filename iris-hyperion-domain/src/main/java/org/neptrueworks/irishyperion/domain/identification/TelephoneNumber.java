package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.identification.rules.TelephoneNumberPatternRule;

import java.util.Locale;

public record TelephoneNumber(String claim, Locale countryCode/*, TelephoneNumberAreaCode areaCode*/) implements IdentificationClaim {
    public static TelephoneNumber of(String phoneNumber, Locale countryCode,
                                     TelephoneNumberPatternRule telephoneNumberPatternRule) {
        telephoneNumberPatternRule.apply(phoneNumber);
        return new TelephoneNumber(phoneNumber, countryCode);
    }
}
