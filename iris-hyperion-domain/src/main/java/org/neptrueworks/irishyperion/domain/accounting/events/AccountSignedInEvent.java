package org.neptrueworks.irishyperion.domain.accounting.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AccountSignedInEvent extends DomainEvent {
    private UserIdentifier userId;
    private IdentificationClaim identificationClaim;
    private LocalDateTime signedInAt;
}
