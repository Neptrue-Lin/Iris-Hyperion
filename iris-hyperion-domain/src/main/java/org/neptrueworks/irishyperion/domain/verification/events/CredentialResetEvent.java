package org.neptrueworks.irishyperion.domain.verification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CredentialResetEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identityIdentifier;
    private final UserVerityIdentifier verityIdentifier;
    private final VerificationCredential credential;
    private final LocalDateTime resetAt;
}
