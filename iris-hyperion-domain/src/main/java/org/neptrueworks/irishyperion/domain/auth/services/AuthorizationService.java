package org.neptrueworks.irishyperion.domain.auth.services;

import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class AuthorizationService {
    public abstract AuthorizationCredential authorize(UserIdentifier userId, AuthorizationIdentifier identifier);
}
