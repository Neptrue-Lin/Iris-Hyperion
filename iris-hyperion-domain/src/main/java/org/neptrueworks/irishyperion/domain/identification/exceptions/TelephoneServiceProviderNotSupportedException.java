package org.neptrueworks.irishyperion.domain.identification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.TelephoneNumber;

@Getter
@AllArgsConstructor
public class TelephoneServiceProviderNotSupportedException extends DomainException {
    private final TelephoneNumber telephoneNumber;
}
