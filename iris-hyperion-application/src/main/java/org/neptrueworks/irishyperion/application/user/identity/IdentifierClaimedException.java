package org.neptrueworks.irishyperion.application.user.identity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainException;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;

@Getter
@AllArgsConstructor
public class IdentifierClaimedException extends DomainException {
    private final IdentificationClaim identificationClaim;
}
