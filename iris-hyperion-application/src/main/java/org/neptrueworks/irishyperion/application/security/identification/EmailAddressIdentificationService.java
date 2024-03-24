package org.neptrueworks.irishyperion.application.security.identification;

import org.neptrueworks.irishyperion.application.security.identification.exceptions.InvalidEmailAddressFormatException;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.exceptions.IdentificationDisabledException;
import org.neptrueworks.irishyperion.domain.identification.services.IdentificationService;

public class EmailAddressIdentificationService extends IdentificationService {
    private UserIdentityRepository repository;

    @Override
    public UserIdentity identify(IdentificationClaim identifier) {
        if(!(identifier instanceof EmailAddress emailAddress))
            throw new IllegalArgumentException();

        if(!EmailAddress.isMatch(emailAddress))
            throw new InvalidEmailAddressFormatException();

        UserIdentity userIdentity = this.repository.fetchByIdentificationIdentifierOrError(identifier);
        if(!userIdentity.isIdentificationEnabled())
            throw new IdentificationDisabledException(userIdentity.getUserId(), userIdentity.getIdentificationClaim());

        return userIdentity;
    }
}
