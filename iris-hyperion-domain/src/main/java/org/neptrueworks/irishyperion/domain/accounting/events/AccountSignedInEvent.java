package org.neptrueworks.irishyperion.domain.accounting.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record AccountSignedInEvent(UserIdentifier userId, IdentificationClaim identificationClaim,
                                   LocalDateTime signedInAt) implements DomainEvent {
}
