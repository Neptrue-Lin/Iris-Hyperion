package org.neptrueworks.irishyperion.domain.verification.commands;

import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

public record ResetCredentialCommand(UserVerityIdentifier identifier,
                                     VerificationCredential credential) implements Command {
}
