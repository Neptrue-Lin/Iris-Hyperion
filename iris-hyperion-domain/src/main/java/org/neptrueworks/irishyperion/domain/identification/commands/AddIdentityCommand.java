package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
public class AddIdentityCommand extends Command {
    private UserIdentifier userId;
    private IdentificationClaim identificationClaim;
    private VerificationCredential verificationCredential;
    private LocalDateTime identifierDeactivateAt;
    private LocalDateTime credentialExpireAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddIdentityCommand that = (AddIdentityCommand) o;
        return Objects.equals(userId, that.userId)
                && Objects.equals(identificationClaim, that.identificationClaim)
                && Objects.equals(verificationCredential, that.verificationCredential)
                && Objects.equals(identifierDeactivateAt, that.identifierDeactivateAt)
                && Objects.equals(credentialExpireAt, that.credentialExpireAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, identificationClaim, verificationCredential, identifierDeactivateAt, credentialExpireAt);
    }
}
