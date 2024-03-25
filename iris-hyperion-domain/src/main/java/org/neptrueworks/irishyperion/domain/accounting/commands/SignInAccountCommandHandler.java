package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentity;
import org.neptrueworks.irishyperion.domain.identification.events.VerificationFailedEvent;
import org.neptrueworks.irishyperion.domain.identification.services.IdentificationService;
import org.neptrueworks.irishyperion.domain.identification.services.VerificationService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SignInAccountCommandHandler extends CommandHandler<SignInAccountCommand> {
    private final UserAccountRepository repository;
    private final IdentificationService identificationService;
    private final VerificationService verificationService;

    @Override
    public void handle(EventPublisher eventPublisher, SignInAccountCommand command) {
        UserIdentity userIdentity = this.identificationService.identify(command.getIdentificationClaim());
        boolean isVerified = this.verificationService.verify(userIdentity, command.getVerificationCredential());
        if (!isVerified) {
            eventPublisher.publish(new VerificationFailedEvent(userIdentity.getUserId(),
                    command.getIdentificationClaim(), eventPublisher.getChronographService().currentDateTime()));
            return;
        }

        UserAccount userAccount = this.repository.fetchByIdentifierOrError(userIdentity.getUserId());
        userAccount.signInAccount(eventPublisher, command);
        this.repository.save(userAccount);
    }
}
