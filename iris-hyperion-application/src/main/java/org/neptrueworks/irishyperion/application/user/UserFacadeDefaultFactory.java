package org.neptrueworks.irishyperion.application.user;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.application.user.identity.IdentifierClaimedException;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountFactory;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.core.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.*;
import org.neptrueworks.irishyperion.domain.profiling.UserOutline;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineFactory;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFacadeDefaultFactory {
    private UserAccountRepository accountRepository;
    private UserIdentityFactory identityFactory;
    private UserIdentityRepository identityRepository;
    private UserAccountFactory accountFactory;
    private UserOutlineFactory outlineFactory;
    private UserOutlineRepository outlineRepository;
    private IIdentifierGeneratable<UserIdentifier> identifierGenerator;

    public void create(EventPublisher eventPublisher, IdentificationClaim identificationClaim,
                       VerificationCredential verificationCredential, String username) {
        if (this.identityRepository.exists(identificationClaim)) {
            throw new IdentifierClaimedException(identificationClaim);
        }

        UserIdentifier userId = this.identifierGenerator.nextIdentifier();
        UserIdentity identity = this.identityFactory.create(eventPublisher, userId, identificationClaim,
                verificationCredential);
        this.identityRepository.save(identity);

        UserAccount account = this.accountFactory.create(eventPublisher, userId);
        this.accountRepository.save(account);

        UserOutline outline = this.outlineFactory.create(eventPublisher, userId, username);
        this.outlineRepository.save(outline);

    }
}
