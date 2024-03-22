package org.neptrueworks.irishyperion.domain.profiling.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainException;

@Getter
@AllArgsConstructor
public class IllegalUsernameCharactersException extends DomainException {
    private final String username;
    private final Integer userId;
}
