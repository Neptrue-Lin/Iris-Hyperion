package org.neptrueworks.irishyperion.application.security.authorization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;

@AllArgsConstructor
@Getter
public class JsonWebTokenAuthorizationIdentifier extends AuthorizationIdentifier {
    private String identifier;
}
