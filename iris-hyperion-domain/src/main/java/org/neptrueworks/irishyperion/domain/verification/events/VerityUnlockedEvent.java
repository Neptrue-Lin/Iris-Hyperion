package org.neptrueworks.irishyperion.domain.verification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VerityUnlockedEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final UserVerityIdentifier identifier;
    private final LocalDateTime unlockedAt;
}
