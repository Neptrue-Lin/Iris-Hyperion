package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

public interface ICredentialCryptographyService {
    VerificationCredential encrypt(VerificationCredential rawCredential);
}
