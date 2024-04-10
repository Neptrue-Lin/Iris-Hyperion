package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.identification.TelephoneNumber;

public interface ITelephoneNumberLookupService {
    TelephoneNumberStatus getTelephoneNumberStatus(TelephoneNumber telephoneNumber);
    TelephoneServiceProvider getTelephoneServiceProvider(TelephoneNumber telephoneNumber);
    boolean isVirtual(TelephoneNumber telephoneNumber);
    boolean checkNumberPortability(TelephoneNumber telephoneNumber);
}
