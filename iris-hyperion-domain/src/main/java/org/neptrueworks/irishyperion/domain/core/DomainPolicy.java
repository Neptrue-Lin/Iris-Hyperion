package org.neptrueworks.irishyperion.domain.core;

import org.neptrueworks.irishyperion.domain.auth.AuthenticationCredential;

public abstract class DomainPolicy {
    public abstract void match(AuthenticationCredential credential);
}
