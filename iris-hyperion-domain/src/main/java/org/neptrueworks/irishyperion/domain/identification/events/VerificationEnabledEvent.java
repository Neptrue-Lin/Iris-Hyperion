package org.neptrueworks.irishyperion.domain.identification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VerificationEnabledEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identifier;
    private final LocalDateTime enabledAt;
}
