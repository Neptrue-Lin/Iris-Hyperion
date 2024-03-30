package org.neptrueworks.irishyperion.domain.identification.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;

@Getter
@AllArgsConstructor
public class IdentifierClaimedException extends DomainException {
    private final IdentificationClaim identificationClaim;
}
