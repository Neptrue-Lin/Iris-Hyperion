package org.neptrueworks.irishyperion.domain.verification.services;

import org.neptrueworks.irishyperion.domain.common.DomainService;

public abstract class CredentialPatternRestriction extends DomainService {
    public abstract void restrict(String rawCredential);
}
