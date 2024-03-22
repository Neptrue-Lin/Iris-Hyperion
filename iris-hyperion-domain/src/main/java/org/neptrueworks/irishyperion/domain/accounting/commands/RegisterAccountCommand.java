package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.IdentificationClaim;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

import java.util.Objects;

@Data
@AllArgsConstructor
public class RegisterAccountCommand extends Command {
    private IdentificationClaim identificationClaim;
    private VerificationCredential verificationCredential;
    private String username;

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
