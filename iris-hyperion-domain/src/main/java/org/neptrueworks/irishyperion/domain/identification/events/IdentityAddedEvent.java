package org.neptrueworks.irishyperion.domain.identification.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.time.LocalDateTime;

public record IdentityAddedEvent(UserIdentifier userId, UserIdentityIdentifier identifier,
                                 IdentificationClaim identificationClaim,
                                 LocalDateTime addedAt) implements DomainEvent {
}
