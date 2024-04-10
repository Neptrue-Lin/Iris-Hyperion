package org.neptrueworks.irishyperion.domain.verification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;

@Getter
@AllArgsConstructor
public class CredentialCharacterRequiredException extends DomainException {
    private final Iterable<Character> requiredCharacter;
}
