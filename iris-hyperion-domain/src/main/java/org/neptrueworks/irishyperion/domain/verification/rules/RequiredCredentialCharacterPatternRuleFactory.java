package org.neptrueworks.irishyperion.domain.verification.rules;

import org.springframework.stereotype.Component;

@Component
public class RequiredCredentialCharacterPatternRuleFactory extends CredentialCharacterPatternRuleFactory {
    @Override
    public CredentialCharacterPatternRule createAlphabeticRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.LETTERS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createDigitRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.DIGITS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createUpperCaseRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.UPPERCASES.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createLowerCaseRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.LOWERCASES.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createAlphanumericRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.ALPHANUMERICS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPunctuationRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.PUNCTUATIONS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPrintableRule() {
        return new RequiredCredentialCharacterPatternRule(CredentialCharacterPattern.PRINTABLES.getCharacters());
    }
}
