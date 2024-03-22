package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.core.DomainService;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

public abstract class VerificationService extends DomainService {
    public abstract boolean verify(UserIdentity identity, VerificationCredential credential);
}
