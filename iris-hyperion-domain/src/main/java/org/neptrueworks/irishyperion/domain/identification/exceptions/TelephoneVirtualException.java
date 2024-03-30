package org.neptrueworks.irishyperion.domain.identification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.PhoneNumber;

@Getter
@AllArgsConstructor
public class TelephoneVirtualException extends DomainException {
    private final PhoneNumber phoneNumber;
}
