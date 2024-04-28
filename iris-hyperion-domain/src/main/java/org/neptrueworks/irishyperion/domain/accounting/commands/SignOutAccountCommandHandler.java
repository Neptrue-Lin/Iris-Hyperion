package org.neptrueworks.irishyperion.domain.accounting.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SignOutAccountCommandHandler extends CommandHandler<SignOutAccountCommand> {
    private final UserAccountRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, SignOutAccountCommand command) {
        UserAccount userAccount = this.repository.fetchByIdentifierOrError(command.userId());
        userAccount.signOutAccount(eventPublisher, command);
        this.repository.save(userAccount);
    }
}
