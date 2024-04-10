package org.neptrueworks.irishyperion.domain.identification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.TelephoneNumber;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.identification.exceptions.IdentificationDisabledException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.TelephoneInactiveException;
import org.neptrueworks.irishyperion.domain.identification.exceptions.TelephoneVirtualException;
import org.neptrueworks.irishyperion.domain.identification.rules.TelephoneNumberPatternRule;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PhoneNumberIdentificationService extends IdentificationService {
    private final UserIdentityRepository repository;
    private final ITelephoneNumberLookupService lookupService;
    private final TelephoneNumberPatternRule telephoneNumberPatternRule;

    @Override
    public UserIdentity identify(IdentificationClaim identifier) {
        if (!(identifier instanceof TelephoneNumber telephoneNumber))
            throw new IllegalArgumentException();

        if (this.lookupService.getTelephoneNumberStatus(telephoneNumber) != TelephoneNumberStatus.ACTIVE)
            throw new TelephoneInactiveException(telephoneNumber);
        if (this.lookupService.isVirtual(telephoneNumber))
            throw new TelephoneVirtualException(telephoneNumber);

        UserIdentity userIdentity = this.repository.fetchByIdentificationClaimOrError(identifier);
        if (!userIdentity.isIdentificationEnabled())
            throw new IdentificationDisabledException(userIdentity.getUserId(), userIdentity.getIdentificationClaim());

        return userIdentity;
    }
}
