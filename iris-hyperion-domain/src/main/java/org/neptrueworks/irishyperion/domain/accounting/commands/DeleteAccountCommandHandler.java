package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteAccountCommandHandler extends CommandHandler<DeleteAccountCommand> {
    private final UserAccountRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, DeleteAccountCommand command) {
        UserAccount userAccount = this.repository.fetchByIdentifierOrError(command.userId());
        userAccount.deleteAccount(eventPublisher, command);
        this.repository.save(userAccount);
    }
}
