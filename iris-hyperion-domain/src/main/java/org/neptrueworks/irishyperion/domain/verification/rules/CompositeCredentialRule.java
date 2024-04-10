package org.neptrueworks.irishyperion.domain.verification.rules;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompositeCredentialRule extends CredentialVerificationRule {
    private final List<CredentialVerificationRule> rules = new ArrayList<>();

    public void addRule(CredentialVerificationRule rule) {
        this.rules.add(rule);
    }

    public void removeRule(CredentialVerificationRule rule) {
        this.rules.remove(rule);
    }

    @Override
    public void apply(CharSequence rawCredential) {
        for (CredentialVerificationRule rule : this.rules)
            rule.apply(rawCredential);
    }
}
