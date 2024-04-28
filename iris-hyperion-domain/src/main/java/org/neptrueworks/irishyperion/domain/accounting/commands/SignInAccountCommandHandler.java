package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityRepository;
import org.neptrueworks.irishyperion.domain.verification.UserVerity;
import org.neptrueworks.irishyperion.domain.verification.UserVerityRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SignInAccountCommandHandler extends CommandHandler<SignInAccountCommand> {
    private final UserAccountRepository accountRepository;
    private final UserIdentityRepository identityRepository;
    private final UserVerityRepository verityRepository;

    @Override
    public void handle(EventPublisher eventPublisher, SignInAccountCommand command) {
        UserIdentity userIdentity = this.identityRepository.fetchByIdentificationClaimOrError(command.identificationClaim());
        UserVerity userVerity = this.verityRepository.fetchByIdentityIdentifierOrError(userIdentity.getIdentifier());
        userVerity.verifyCredential(eventPublisher, command.verificationCredential());
        UserAccount userAccount = this.accountRepository.fetchByIdentifierOrError(userIdentity.getUserId());
        userAccount.signInAccount(eventPublisher, command);
        this.accountRepository.save(userAccount);
    }
}
