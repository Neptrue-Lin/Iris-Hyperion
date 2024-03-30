package org.neptrueworks.irishyperion.domain.auth.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenAuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenPayload;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonWebTokenAuthorizationService extends AuthorizationService {
    private JsonWebTokenTokenizationService service;

    @Override
    public AuthorizationCredential authorize(UserIdentifier userId, AuthorizationIdentifier identifier) {
        JsonWebTokenPayload payload = new JsonWebTokenPayload();
        return new JsonWebTokenAuthorizationCredential(payload, this.service);
    }
}
