package org.neptrueworks.irishyperion.domain.auth;

public abstract class AuthenticationService {
    public abstract void authenticate(AuthorizationCredential credential);
}
