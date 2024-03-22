package org.neptrueworks.irishyperion.domain.identification;

public interface ICredentialInvalidatable{
    void invalidate();
    boolean isInvalidated();
}
