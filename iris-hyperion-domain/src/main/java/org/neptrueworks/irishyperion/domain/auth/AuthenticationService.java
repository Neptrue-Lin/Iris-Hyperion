package org.neptrueworks.irishyperion.domain.auth;

import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public interface AuthenticationService {
    UserIdentifier authenticate(AuthorizationCredential credential);
}
