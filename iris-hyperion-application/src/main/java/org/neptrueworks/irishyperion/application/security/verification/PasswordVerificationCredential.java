package org.neptrueworks.irishyperion.application.security.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;

@AllArgsConstructor
public class PasswordVerificationCredential extends VerificationCredential {
    @Getter
    private CharSequence credential;
}
