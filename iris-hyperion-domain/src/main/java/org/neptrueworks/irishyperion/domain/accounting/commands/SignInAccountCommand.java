package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

@Getter
@AllArgsConstructor
public class SignInAccountCommand extends Command {
    private final IdentificationClaim identificationClaim;
    private final VerificationCredential verificationCredential;
}
