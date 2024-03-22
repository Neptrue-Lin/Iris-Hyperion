package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

import java.util.Objects;

@Data
@AllArgsConstructor
public class SignInAccountCommand extends Command {
    private IdentificationClaim identificationClaim;
    private VerificationCredential verificationCredential;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignInAccountCommand that = (SignInAccountCommand) o;
        return Objects.equals(identificationClaim, that.identificationClaim) && Objects.equals(verificationCredential, that.verificationCredential);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationClaim, verificationCredential);
    }
}
