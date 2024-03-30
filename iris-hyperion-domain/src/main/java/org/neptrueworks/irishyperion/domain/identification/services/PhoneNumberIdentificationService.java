package org.neptrueworks.irishyperion.domain.identification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.PhoneNumber;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.exceptions.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AllArgsConstructor
public class PhoneNumberIdentificationService extends IdentificationService {
    private UserIdentityRepository repository;
    private ITelephoneNumberLookupService lookupService;

    @Override
    public UserIdentity identify(IdentificationClaim identifier) {
        if (!(identifier instanceof PhoneNumber phoneNumber))
            throw new IllegalArgumentException();

        if (!PhoneNumber.isMatch(phoneNumber.getClaim()))
            throw new InvalidPhoneNumberFormatException();
        if (phoneNumber.getCountryCode() != Locale.CHINA)
            throw new TelephoneCountryNotSupportedException(phoneNumber);

        if (this.lookupService.getTelephoneNumberStatus(phoneNumber) != TelephoneNumberStatus.ACTIVE)
            throw new TelephoneInactiveException(phoneNumber);
        if (this.lookupService.isVirtual(phoneNumber))
            throw new TelephoneVirtualException(phoneNumber);

        UserIdentity userIdentity = this.repository.fetchByIdentificationIdentifierOrError(identifier);
        if (!userIdentity.isIdentificationEnabled())
            throw new IdentificationDisabledException(userIdentity.getUserId(), userIdentity.getIdentificationClaim());

        return userIdentity;
    }
}
