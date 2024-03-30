package org.neptrueworks.irishyperion.domain.identification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class IdentityAddedEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identifier;
    private final IdentificationClaim identificationClaim;
    private final LocalDateTime addedAt;
}
