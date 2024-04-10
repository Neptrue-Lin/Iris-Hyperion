package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AddVerityCommand extends Command {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier userIdentityIdentifier;
    private final VerificationCredential verificationCredential;
    private final LocalDateTime credentialExpireAt;
}
