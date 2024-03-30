package org.neptrueworks.irishyperion.domain.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PasswordVerificationCredential extends VerificationCredential {
    @Getter
    private CharSequence credential;
}
