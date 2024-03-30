package org.neptrueworks.irishyperion.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AuthorizationFailedEvent extends DomainEvent {
    private final AuthorizationIdentifier identifier;
    private final LocalDateTime failedAt;
}
