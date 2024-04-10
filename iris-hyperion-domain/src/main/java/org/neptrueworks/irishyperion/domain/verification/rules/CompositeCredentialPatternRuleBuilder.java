package org.neptrueworks.irishyperion.domain.verification.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompositeCredentialPatternRuleBuilder {
    private final CompositeCredentialRule compositeCredentialRule = new CompositeCredentialRule();
    private final LegalCredentialCharacterPatternRuleFactory legalCharacterPatternRuleFactory;
    private final IllegalCredentialCharacterPatternRuleFactory illegalCharacterPatternRuleFactory;
    private final RequiredCredentialCharacterPatternRuleFactory requiredCharacterPatternRuleFactory;

    public CompositeCredentialPatternRuleBuilder requireLength(int minLength, int maxLength) {
        this.compositeCredentialRule.addRule(new CredentialLengthPatternRule(minLength, maxLength));
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requireDigit() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createDigitRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requireLetter() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createAlphabeticRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requireUpperCase() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createUpperCaseRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requireLowerCase() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createLowerCaseRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requirePunctuation() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createPunctuationRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requirePrintable() {
        this.compositeCredentialRule.addRule(this.requiredCharacterPatternRuleFactory.createPrintableRule());
        return this;
    }

    public CompositeCredentialPatternRuleBuilder requireCharacter(CharSequence characters) {
        this.compositeCredentialRule.addRule(new RequiredCredentialCharacterPatternRule(characters));
        return this;
    }

    public CompositeCredentialRule build() {
        return this.compositeCredentialRule;
    }
}
