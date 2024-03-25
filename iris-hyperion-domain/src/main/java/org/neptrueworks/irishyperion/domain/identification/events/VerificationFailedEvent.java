package org.neptrueworks.irishyperion.domain.identification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VerificationFailedEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final IdentificationClaim identificationClaim;
    private final LocalDateTime failedAt;
}
