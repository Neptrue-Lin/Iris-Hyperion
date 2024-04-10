package org.neptrueworks.irishyperion.domain.verification.rules;

import org.springframework.stereotype.Component;

@Component
public class LegalCredentialCharacterPatternRuleFactory extends CredentialCharacterPatternRuleFactory {
    @Override
    public CredentialCharacterPatternRule createAlphabeticRule() {
        return new LegalCredentialCharacterPatternRule(CredentialCharacterPattern.LETTERS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createDigitRule() {
        return new LegalCredentialCharacterPatternRule(CredentialCharacterPattern.DIGITS.getCharacters());
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
        return new LegalCredentialCharacterPatternRule(CredentialCharacterPattern.ALPHANUMERICS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPunctuationRule() {
        return new LegalCredentialCharacterPatternRule(CredentialCharacterPattern.PUNCTUATIONS.getCharacters());
    }

    @Override
    public CredentialCharacterPatternRule createPrintableRule() {
        return new LegalCredentialCharacterPatternRule(CredentialCharacterPattern.PRINTABLES.getCharacters());
    }
}
