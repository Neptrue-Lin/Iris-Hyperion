package org.neptrueworks.irishyperion.domain.verification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.verification.rules.CredentialVerificationRule;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasswordCredentialPatternRestriction extends CredentialPatternRestriction {
    private CredentialVerificationRule verificationRule;

    @Override
    public void restrict(String rawCredential) {
        this.verificationRule.apply(rawCredential);
    }
}