package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class RegisterAccountCommand extends Command {
    private final IdentificationClaim identificationClaim;
    private final VerificationCredential verificationCredential;
    private final String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterAccountCommand that = (RegisterAccountCommand) o;
        return Objects.equals(identificationClaim, that.identificationClaim) && Objects.equals(verificationCredential, that.verificationCredential) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationClaim, verificationCredential, username);
    }
}
