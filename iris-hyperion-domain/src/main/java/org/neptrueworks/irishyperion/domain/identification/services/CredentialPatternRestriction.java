package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.core.DomainService;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

public abstract class CredentialPatternRestriction extends DomainService {
    public abstract void restrict(VerificationCredential credential);
}
