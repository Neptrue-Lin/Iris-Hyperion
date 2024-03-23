package org.neptrueworks.irishyperion.application.security.authorization;

import io.jsonwebtoken.Jwts;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationService;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public class JsonWebTokenAuthorizationService extends AuthorizationService {
    @Override
    public AuthorizationCredential authorize(UserIdentifier userId, AuthorizationIdentifier identifier) {
        return new JsonWebTokenAuthorizationCredential(Jwts.claims()
                .id(identifier.getIdentifier())
                .subject(userId.getIdentifier())
                .build());
    }
}
