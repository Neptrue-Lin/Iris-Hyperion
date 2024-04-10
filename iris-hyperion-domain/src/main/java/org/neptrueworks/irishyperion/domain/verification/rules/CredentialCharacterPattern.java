package org.neptrueworks.irishyperion.domain.verification.rules;

import lombok.Getter;

public enum CredentialCharacterPattern {
    LOWERCASES("abcdefghijklmnopqrstuvwxyz"),
    UPPERCASES("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    DIGITS("0123456789"),
    PUNCTUATIONS("!@#$%^&*()-_=+[]{};:,.<>/?"),
    LETTERS(LOWERCASES.getCharacters() + UPPERCASES.getCharacters()),
    ALPHANUMERICS(LETTERS.getCharacters() + DIGITS.getCharacters()),
    PRINTABLES(ALPHANUMERICS.getCharacters() + PUNCTUATIONS.getCharacters());

    @Getter
    private final String characters;

    CredentialCharacterPattern(String characters) {
        this.characters = characters;
    }
}
