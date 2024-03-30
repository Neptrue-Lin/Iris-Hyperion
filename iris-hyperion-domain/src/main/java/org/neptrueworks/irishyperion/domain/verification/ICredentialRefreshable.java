package org.neptrueworks.irishyperion.domain.verification;

import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;

public interface ICredentialRefreshable {
    void refresh(IdentificationClaim identifier);
}
