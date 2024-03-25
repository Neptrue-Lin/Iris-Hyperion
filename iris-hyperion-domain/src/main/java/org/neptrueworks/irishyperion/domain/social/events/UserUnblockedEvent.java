package org.neptrueworks.irishyperion.domain.social.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserUnblockedEvent extends DomainEvent {
    private final UserIdentifier unblockedUser;
    private final UserIdentifier unblockedBy;
    private final LocalDateTime unblockedAt;
}
