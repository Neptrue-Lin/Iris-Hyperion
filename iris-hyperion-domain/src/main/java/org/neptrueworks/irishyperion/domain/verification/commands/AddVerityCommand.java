package org.neptrueworks.irishyperion.domain.verification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;

public record AddVerityCommand(UserIdentifier userId, UserIdentityIdentifier userIdentityIdentifier,
                               VerificationCredential verificationCredential,
                               LocalDateTime credentialExpireAt) implements Command {
}
