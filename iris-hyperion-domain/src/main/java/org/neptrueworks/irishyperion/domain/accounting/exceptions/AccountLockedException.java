package org.neptrueworks.irishyperion.domain.accounting.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class AccountLockedException extends DomainException {
    private final UserIdentifier userId;
}
