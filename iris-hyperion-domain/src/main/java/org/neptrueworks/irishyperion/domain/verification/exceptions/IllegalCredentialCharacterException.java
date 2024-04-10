package org.neptrueworks.irishyperion.domain.verification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;

@Getter
@AllArgsConstructor
public class IllegalCredentialCharacterException extends DomainException {
    private final char illegalCharacter;
}
