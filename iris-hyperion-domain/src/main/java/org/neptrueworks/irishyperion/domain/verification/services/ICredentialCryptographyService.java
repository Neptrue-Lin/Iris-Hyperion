package org.neptrueworks.irishyperion.domain.verification.services;

import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public interface ICredentialCryptographyService {
    VerificationCredential encrypt(VerificationCredential rawCredential);
}
