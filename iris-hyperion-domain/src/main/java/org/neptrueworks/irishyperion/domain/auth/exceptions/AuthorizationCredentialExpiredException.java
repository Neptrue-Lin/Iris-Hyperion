package org.neptrueworks.irishyperion.domain.auth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class AuthorizationCredentialExpiredException extends DomainException {
    private final UserIdentifier userId;
    private final AuthorizationIdentifier identifier;
}
