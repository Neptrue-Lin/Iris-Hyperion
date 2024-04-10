package org.neptrueworks.irishyperion.domain.verification.rules;

public abstract class CredentialCharacterPatternRuleFactory {
    public abstract CredentialCharacterPatternRule createAlphabeticRule();
    public abstract CredentialCharacterPatternRule createDigitRule();
    public abstract CredentialCharacterPatternRule createUpperCaseRule();
    public abstract CredentialCharacterPatternRule createLowerCaseRule();
    public abstract CredentialCharacterPatternRule createAlphanumericRule();
    public abstract CredentialCharacterPatternRule createPunctuationRule();
    public abstract CredentialCharacterPatternRule createPrintableRule();
}
