package org.neptrueworks.irishyperion.domain.identification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class IdentificationDisabledEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identifier;
    private final LocalDateTime disabledAt;
}
