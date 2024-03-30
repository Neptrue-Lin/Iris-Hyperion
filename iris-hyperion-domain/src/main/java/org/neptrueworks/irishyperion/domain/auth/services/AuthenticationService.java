package org.neptrueworks.irishyperion.domain.auth.services;

import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;

public abstract class AuthenticationService {
    public abstract void authenticate(AuthorizationCredential credential);
}
