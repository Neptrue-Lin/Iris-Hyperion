package org.neptrueworks.irishyperion.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JsonWebTokenAuthorizationIdentifier extends AuthorizationIdentifier {
    private String identifier;
}
