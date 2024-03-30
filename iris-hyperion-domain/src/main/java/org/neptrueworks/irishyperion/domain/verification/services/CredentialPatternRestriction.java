package org.neptrueworks.irishyperion.domain.verification.services;

import org.neptrueworks.irishyperion.domain.common.DomainService;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public abstract class CredentialPatternRestriction extends DomainService {
    public abstract void restrict(VerificationCredential rawCredential);
    public abstract boolean isRestricted(VerificationCredential rawCredential);
}
