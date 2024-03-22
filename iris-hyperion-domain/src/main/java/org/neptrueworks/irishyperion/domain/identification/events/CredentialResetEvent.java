package org.neptrueworks.irishyperion.domain.identification.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CredentialResetEvent extends DomainEvent {
    private UserIdentifier userId;
    private IdentificationClaim identifier;
    private VerificationCredential credential;
    private LocalDateTime resetAt;
}
