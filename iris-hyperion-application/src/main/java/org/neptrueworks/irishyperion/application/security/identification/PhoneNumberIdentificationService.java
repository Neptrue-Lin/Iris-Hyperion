package org.neptrueworks.irishyperion.application.security.identification;

import org.neptrueworks.irishyperion.application.security.identification.exceptions.InvalidPhoneNumberFormatException;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.exceptions.IdentificationDisabledException;
import org.neptrueworks.irishyperion.domain.identification.services.IdentificationService;

public class PhoneNumberIdentificationService extends IdentificationService {
    private UserIdentityRepository repository;

    @Override
    public UserIdentity identify(IdentificationClaim identifier) {
        if(!(identifier instanceof PhoneNumber phoneNumber))
            throw new IllegalArgumentException();

        if(!PhoneNumber.isMatch(phoneNumber))
            throw new InvalidPhoneNumberFormatException();

        UserIdentity userIdentity = this.repository.fetchByIdentificationIdentifierOrError(identifier);
        if(!userIdentity.isIdentificationEnabled())
            throw new IdentificationDisabledException(userIdentity.getUserId(), userIdentity.getIdentificationClaim());

        return userIdentity;
    }
}
