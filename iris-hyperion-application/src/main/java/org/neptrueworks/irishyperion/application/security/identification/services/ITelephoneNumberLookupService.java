package org.neptrueworks.irishyperion.application.security.identification.services;

import org.neptrueworks.irishyperion.application.security.identification.PhoneNumber;

import java.util.Locale;

public interface ITelephoneNumberLookupService {
    Locale.IsoCountryCode getCountryCode(PhoneNumber phoneNumber);
    TelephoneNumberArea getAreaCode(PhoneNumber phoneNumber);
    TelephoneNumberStatus getTelephoneNumberStatus(PhoneNumber phoneNumber);
    TelecomCarrier getTelecomCarrier(PhoneNumber phoneNumber);
    TelephoneServiceProvider getTelephoneServiceProvider(PhoneNumber phoneNumber);
    boolean isVirtual(PhoneNumber phoneNumber);
    boolean checkNumberPortability(PhoneNumber phoneNumber);
}
