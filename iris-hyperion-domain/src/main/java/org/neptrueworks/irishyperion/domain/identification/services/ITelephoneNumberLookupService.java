package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.identification.PhoneNumber;

public interface ITelephoneNumberLookupService {
    TelephoneNumberStatus getTelephoneNumberStatus(PhoneNumber phoneNumber);
    TelephoneServiceProvider getTelephoneServiceProvider(PhoneNumber phoneNumber);
    boolean isVirtual(PhoneNumber phoneNumber);
    boolean checkNumberPortability(PhoneNumber phoneNumber);
}
