package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.common.DomainService;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;

public abstract class IdentificationService extends DomainService {
    public abstract UserIdentity identify(IdentificationClaim identifier);
}
