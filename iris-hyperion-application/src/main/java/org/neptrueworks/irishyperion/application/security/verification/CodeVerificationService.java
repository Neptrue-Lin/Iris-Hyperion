package org.neptrueworks.irishyperion.application.security.verification;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.VerificationCredential;
import org.neptrueworks.irishyperion.domain.identification.exceptions.VerificationDisabledException;
import org.neptrueworks.irishyperion.domain.identification.services.VerificationService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class CodeVerificationService extends VerificationService {
    @Override
    public boolean verify(UserIdentity identity, VerificationCredential credential) {
        if(!(credential instanceof CodeVerificationCredential verificationCodeCredential))
            throw new IllegalArgumentException();

        if (!identity.isVerificationEnabled())
            throw new VerificationDisabledException(identity.getUserId(), identity.getIdentificationClaim());
        boolean isVerified = Objects.equals(verificationCodeCredential, identity.getVerificationCredential());
        return isVerified;
    }
}
