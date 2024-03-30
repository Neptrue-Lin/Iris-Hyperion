package org.neptrueworks.irishyperion.domain.verification;

public interface ICredentialInvalidatable{
    void invalidate();
    boolean isInvalidated();
}
