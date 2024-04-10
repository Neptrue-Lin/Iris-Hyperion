package org.neptrueworks.irishyperion.domain.verification.rules;

public abstract class CredentialVerificationRule {
    public abstract void apply(CharSequence rawCredential);
}
