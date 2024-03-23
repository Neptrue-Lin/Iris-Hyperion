package org.neptrueworks.irishyperion.domain.auth;

import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class AuthorizationService {
    public abstract AuthorizationCredential authorize(UserIdentifier userId, AuthorizationIdentifier identifier);
}
