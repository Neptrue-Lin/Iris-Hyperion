package org.neptrueworks.irishyperion.domain.auth;

import org.neptrueworks.irishyperion.domain.core.Command;

public abstract class AuthorizationService {
    public abstract boolean authorize(Command command, AuthorizationIdentifier identifier,
                                      AuthorizationCredential credential);
}
