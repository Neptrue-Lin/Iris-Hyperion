package org.neptrueworks.irishyperion.domain.verification.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record VerificationFailedEvent(UserIdentifier userId, IdentificationClaim identificationClaim,
                                      LocalDateTime failedAt) implements DomainEvent {
}
