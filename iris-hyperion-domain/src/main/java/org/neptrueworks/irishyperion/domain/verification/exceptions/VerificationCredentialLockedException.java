package org.neptrueworks.irishyperion.domain.verification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

@Getter
@AllArgsConstructor
public class VerificationCredentialLockedException extends DomainException {
    private final UserIdentifier userId;
    private final UserVerityIdentifier identifier;
}
