package org.neptrueworks.irishyperion.domain.verification.rules;

import org.springframework.stereotype.Component;

@Component
public class IllegalCredentialCharacterPatternRuleFactory extends CredentialCharacterPatternRuleFactory {
    @Override
    public CredentialCharacterPatternRule createAlphabeticRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.LETTERS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createDigitRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.DIGITS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createUpperCaseRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.UPPERCASES.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createLowerCaseRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.LOWERCASES.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createAlphanumericRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.ALPHANUMERICS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPunctuationRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.PUNCTUATIONS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPrintableRule() {
        return new IllegalCredentialCharacterPatternRule(CredentialCharacterPattern.PRINTABLES.getCharacters());
    }
}
