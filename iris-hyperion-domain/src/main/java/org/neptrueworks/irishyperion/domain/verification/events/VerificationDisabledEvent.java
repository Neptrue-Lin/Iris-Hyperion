package org.neptrueworks.irishyperion.domain.verification.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

import java.time.LocalDateTime;

public record VerificationDisabledEvent(UserIdentifier userId, UserVerityIdentifier verityIdentifier,
                                        LocalDateTime disabledAt) implements DomainEvent {
}
