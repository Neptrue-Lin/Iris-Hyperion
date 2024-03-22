package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnlockAccountCommandHandler extends CommandHandler<UnlockAccountCommand> {
    private UserAccountRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, UnlockAccountCommand command) {
        UserAccount userAccount = this.repository.fetchByIdentifierOrError(command.getUserId());
        userAccount.unlockAccount(eventPublisher,command);
        this.repository.save(userAccount);
    }
}
