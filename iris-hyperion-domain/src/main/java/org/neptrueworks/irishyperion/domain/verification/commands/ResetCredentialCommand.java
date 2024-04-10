package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

@Getter
@AllArgsConstructor
public class ResetCredentialCommand extends Command {
    private final UserVerityIdentifier identifier;
    private final VerificationCredential credential;
}
