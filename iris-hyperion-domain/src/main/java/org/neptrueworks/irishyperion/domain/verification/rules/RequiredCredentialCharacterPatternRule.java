package org.neptrueworks.irishyperion.domain.verification.rules;

import org.neptrueworks.irishyperion.domain.verification.exceptions.CredentialCharacterRequiredException;

import java.util.HashSet;

public class RequiredCredentialCharacterPatternRule extends CredentialCharacterPatternRule {
    public RequiredCredentialCharacterPatternRule(CharSequence characters) {
        super(characters);
    }

    @Override
    public void apply(CharSequence rawCredential) {
        HashSet<Character> remainingCharacters = new HashSet<>(this.characters);
        HashSet<Character> rawCharacters = new HashSet<>();
        rawCredential.chars().forEach(c -> rawCharacters.add((char)c));
        remainingCharacters.removeAll(rawCharacters);
        if (!remainingCharacters.isEmpty())
            throw new CredentialCharacterRequiredException(remainingCharacters);
    }
}
