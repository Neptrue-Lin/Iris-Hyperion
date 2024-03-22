package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteAccountCommandHandler extends CommandHandler<DeleteAccountCommand> {
    private UserAccountRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DeleteAccountCommand command) {
        UserAccount userAccount = this.repository.fetchByIdentifierOrError(command.getUserId());
        userAccount.deleteAccount(eventPublisher, command);
        this.repository.save(userAccount);
    }
}
