package org.neptrueworks.irishyperion.domain.verification.services;

public interface ICredentialCryptographyService {
    CharSequence encrypt(CharSequence rawCredential);
}
