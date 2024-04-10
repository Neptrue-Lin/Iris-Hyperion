package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.common.DomainService;

public abstract class ClaimPatternRestriction extends DomainService {
    public abstract void restrict(String claim);
}
