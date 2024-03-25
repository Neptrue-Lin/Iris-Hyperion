package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class ResetCredentialCommand extends Command {
    private final UserIdentifier userId;
    private final IdentificationClaim identifier;
    private final VerificationCredential credential;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResetCredentialCommand that = (ResetCredentialCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(identifier, that.identifier) && Objects.equals(credential, that.credential);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, identifier, credential);
    }
}
