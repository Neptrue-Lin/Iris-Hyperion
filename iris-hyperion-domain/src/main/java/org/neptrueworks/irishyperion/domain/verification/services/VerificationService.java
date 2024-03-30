package org.neptrueworks.irishyperion.domain.verification.services;

import org.neptrueworks.irishyperion.domain.common.DomainService;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public abstract class VerificationService extends DomainService {
    public abstract boolean verify(UserIdentity identity, VerificationCredential credential);
}
