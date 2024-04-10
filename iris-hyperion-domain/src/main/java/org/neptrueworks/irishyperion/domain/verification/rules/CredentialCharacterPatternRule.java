package org.neptrueworks.irishyperion.domain.verification.rules;

import java.util.HashSet;

public abstract class CredentialCharacterPatternRule extends CredentialPatternRule {
    protected HashSet<Character> characters = new HashSet<>();
    public CredentialCharacterPatternRule(CharSequence characters){
        characters.chars().forEach(c -> this.characters.add((char)c));
    }
}
