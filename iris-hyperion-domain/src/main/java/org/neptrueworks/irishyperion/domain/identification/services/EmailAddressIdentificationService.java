package org.neptrueworks.irishyperion.domain.identification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.EmailAddress;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.exceptions.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailAddressIdentificationService extends IdentificationService {
    private UserIdentityRepository repository;
    private IEmailAddressLookupService lookupService;

    @Override
    public UserIdentity identify(IdentificationClaim identifier) {
        if(!(identifier instanceof EmailAddress emailAddress))
            throw new IllegalArgumentException();

        if(!EmailAddress.isMatch(emailAddress.getClaim()))
            throw new InvalidEmailAddressFormatException();

        if(this.lookupService.isDisposableMailServiceProvider(emailAddress))
            throw new MailServiceProviderDisposableException(emailAddress);
        if (!this.lookupService.checkMailExchangeRecord(emailAddress))
            throw new MailExchangeRecordNotFoundException(emailAddress);
        if (!this.lookupService.checkMailDeliverability(emailAddress))
            throw new MailUndeliverableException(emailAddress);

        UserIdentity userIdentity = this.repository.fetchByIdentificationIdentifierOrError(identifier);
        if(!userIdentity.isIdentificationEnabled())
            throw new IdentificationDisabledException(userIdentity.getUserId(), userIdentity.getIdentificationClaim());

        return userIdentity;
    }
}
