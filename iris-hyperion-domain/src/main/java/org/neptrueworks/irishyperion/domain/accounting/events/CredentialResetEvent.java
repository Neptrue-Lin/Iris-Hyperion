package org.neptrueworks.irishyperion.domain.accounting.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CredentialResetEvent extends DomainEvent {
    private final UserIdentifier userId;
    private final IdentificationClaim identifier;
    private final VerificationCredential credential;
    private final LocalDateTime resetAt;
}
