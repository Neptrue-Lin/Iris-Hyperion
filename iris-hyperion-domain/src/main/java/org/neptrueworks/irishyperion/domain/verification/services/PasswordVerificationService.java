package org.neptrueworks.irishyperion.domain.verification.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.exceptions.VerificationDisabledException;
import org.neptrueworks.irishyperion.domain.verification.CodeVerificationCredential;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PasswordVerificationService extends VerificationService {
    private UserAccountRepository accountRepository;

    @Override
    public boolean verify(UserIdentity identity, VerificationCredential rawCredential) {
        if(!(rawCredential instanceof CodeVerificationCredential verificationCodeCredential))
            throw new IllegalArgumentException();

        if (!identity.isVerificationEnabled())
            throw new VerificationDisabledException(identity.getUserId(), identity.getIdentificationClaim());

        UserAccount account = this.accountRepository.fetchByIdentifierOrError(identity.getUserId());
        boolean isVerified = Objects.equals(rawCredential, account.getCredential());
        return isVerified;
    }
}
