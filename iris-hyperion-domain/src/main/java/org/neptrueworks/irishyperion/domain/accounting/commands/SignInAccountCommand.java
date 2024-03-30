package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class SignInAccountCommand extends Command {
    private final IdentificationClaim identificationClaim;
    private final VerificationCredential verificationCredential;

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
