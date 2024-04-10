package org.neptrueworks.irishyperion.domain.identification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailAddressHostPartOverLengthException extends InvalidEmailAddressFormatException {
    private final int maxHostPartLength;
}
