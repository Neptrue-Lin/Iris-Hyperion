package org.neptrueworks.irishyperion.domain.verification.rules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neptrueworks.irishyperion.domain.verification.exceptions.CredentialOverlengthException;
import org.neptrueworks.irishyperion.domain.verification.exceptions.CredentialOvershortException;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CredentialLengthPatternRule extends CredentialPatternRule {
    public static int DEFAULT_MIN_LENGTH = 1;
    public static int DEFAULT_MAX_LENGTH = Integer.MAX_VALUE;

    private int minLength = DEFAULT_MIN_LENGTH;
    private int maxLength = DEFAULT_MAX_LENGTH;

    @Override
    public void apply(CharSequence rawCredential) {
        if (rawCredential.length() < this.minLength)
            throw new CredentialOvershortException();
        if (rawCredential.length() > this.maxLength)
            throw new CredentialOverlengthException();
    }
}
