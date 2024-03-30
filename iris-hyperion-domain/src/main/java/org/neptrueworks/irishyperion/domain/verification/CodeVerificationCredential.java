package org.neptrueworks.irishyperion.domain.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.verification.services.CredentialPatternRestriction;
import org.neptrueworks.irishyperion.domain.verification.services.ICredentialCryptographyService;

@AllArgsConstructor
@Getter
public class CodeVerificationCredential extends VerificationCredential {
    private CharSequence credential;
    private ICredentialCryptographyService credentialCryptographyService;
    private CredentialPatternRestriction restriction;
}
