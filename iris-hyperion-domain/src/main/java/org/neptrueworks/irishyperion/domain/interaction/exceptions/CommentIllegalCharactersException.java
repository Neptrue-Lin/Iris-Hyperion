package org.neptrueworks.irishyperion.domain.interaction.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class CommentIllegalCharactersException extends DomainException {
    private Iterable<Character> illegalCharacters;
    private UserIdentifier userId;
}
