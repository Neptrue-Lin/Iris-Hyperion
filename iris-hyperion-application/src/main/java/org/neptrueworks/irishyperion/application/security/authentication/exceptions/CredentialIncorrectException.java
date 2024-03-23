package org.neptrueworks.irishyperion.application.security.authentication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.core.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class CredentialIncorrectException extends DomainException {
    private final UserIdentifier userId;
    private final AuthorizationIdentifier identifier;
}
