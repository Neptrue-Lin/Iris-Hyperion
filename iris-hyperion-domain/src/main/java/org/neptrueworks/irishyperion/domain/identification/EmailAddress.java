package org.neptrueworks.irishyperion.domain.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.services.EmailAddressPatternRestriction;

@Getter
@AllArgsConstructor
public class EmailAddress extends IdentificationClaim {
    public static final String EMAIL_SEPARATOR = "@";
    public static final String LEVEL_SEPARATOR = "\\.";
    private String claim;

    public static EmailAddress of(String emailAddress, EmailAddressPatternRestriction restriction) {
        restriction.restrict(emailAddress);
        return new EmailAddress(emailAddress);
    }
}
