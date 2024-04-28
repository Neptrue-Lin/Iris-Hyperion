package org.neptrueworks.irishyperion.domain.identification;

import org.neptrueworks.irishyperion.domain.identification.services.EmailAddressPatternRestriction;

public record EmailAddress(String claim) implements IdentificationClaim {
    public static final String EMAIL_SEPARATOR = "@";
    public static final String LEVEL_SEPARATOR = "\\.";
    public static EmailAddress of(String emailAddress, EmailAddressPatternRestriction restriction) {
        restriction.restrict(emailAddress);
        return new EmailAddress(emailAddress);
    }
}
