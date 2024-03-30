package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class AddIdentityCommand extends Command {
    private final UserIdentifier userId;
    private final IdentificationClaim identificationClaim;
    private final VerificationCredential verificationCredential;
    private final LocalDateTime identifierDeactivateAt;
    private final LocalDateTime credentialExpireAt;

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
