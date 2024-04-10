package org.neptrueworks.irishyperion.domain.verification.rules;

import org.neptrueworks.irishyperion.domain.verification.exceptions.IllegalCredentialCharacterException;

public class IllegalCredentialCharacterPatternRule extends CredentialCharacterPatternRule {
    public IllegalCredentialCharacterPatternRule(String characters) {
        super(characters);
    }

    @Override
    public void apply(CharSequence rawCredential) {
        rawCredential.chars().forEach(character -> {
            if (this.characters.contains((char) character))
                throw new IllegalCredentialCharacterException((char) character);
        });
    }
}
