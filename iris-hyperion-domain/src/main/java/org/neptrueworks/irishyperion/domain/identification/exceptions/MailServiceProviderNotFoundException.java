package org.neptrueworks.irishyperion.domain.identification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.EmailAddress;

@AllArgsConstructor
@Getter
public class MailServiceProviderNotFoundException extends DomainException {
    private final EmailAddress emailAddress;
}
