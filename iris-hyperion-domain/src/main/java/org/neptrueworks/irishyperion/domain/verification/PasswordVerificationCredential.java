package org.neptrueworks.irishyperion.domain.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.verification.services.CredentialPatternRestriction;
import org.neptrueworks.irishyperion.domain.verification.services.ICredentialCryptographyService;

@Getter
@AllArgsConstructor
public class PasswordVerificationCredential extends VerificationCredential {
    private CharSequence credential;

    public static PasswordVerificationCredential of(String credential,
                                                    ICredentialCryptographyService cryptographyService,
                                                    CredentialPatternRestriction credentialPatternRestriction) {
        CharSequence encryptedCredential = cryptographyService.encrypt(credential);
        credentialPatternRestriction.restrict(credential);
        return new PasswordVerificationCredential(encryptedCredential);
    }
}
