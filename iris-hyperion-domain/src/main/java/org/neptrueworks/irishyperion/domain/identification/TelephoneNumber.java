package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.rules.TelephoneNumberPatternRule;

import java.util.Locale;

@AllArgsConstructor
@Getter
public class TelephoneNumber extends IdentificationClaim {
    private String claim;
    private Locale countryCode;
//    private TelephoneNumberAreaCode areaCode;

    public static TelephoneNumber of(String phoneNumber, Locale countryCode,
                                     TelephoneNumberPatternRule telephoneNumberPatternRule) {
        telephoneNumberPatternRule.apply(phoneNumber);
        return new TelephoneNumber(phoneNumber, countryCode);
    }
}
