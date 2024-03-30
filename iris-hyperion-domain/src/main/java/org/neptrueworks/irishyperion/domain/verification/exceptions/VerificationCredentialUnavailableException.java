package org.neptrueworks.irishyperion.domain.verification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class VerificationCredentialUnavailableException extends DomainException {
    private final UserIdentifier userId;
    private final IdentificationClaim identifier;
}
