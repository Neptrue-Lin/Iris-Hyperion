package org.neptrueworks.irishyperion.domain.accounting.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public record RegisterAccountCommand(IdentificationClaim identificationClaim,
                                     VerificationCredential verificationCredential,
                                     String username) implements Command {
}
