package org.neptrueworks.irishyperion.domain.verification.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;

public record CredentialResetEvent(UserIdentifier userId, UserIdentityIdentifier identityIdentifier,
                                   UserVerityIdentifier verityIdentifier, VerificationCredential credential,
                                   LocalDateTime resetAt) implements DomainEvent {
}
