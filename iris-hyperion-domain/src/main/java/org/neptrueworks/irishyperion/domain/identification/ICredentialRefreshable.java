package org.neptrueworks.irishyperion.domain.identification;

public interface ICredentialRefreshable {
    void refresh(IdentificationClaim identifier);
}
