package org.neptrueworks.irishyperion.domain.accounting;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.common.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.*;
import org.neptrueworks.irishyperion.domain.identification.exceptions.IdentifierClaimedException;
import org.neptrueworks.irishyperion.domain.profiling.UserOutline;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineFactory;
import org.neptrueworks.irishyperion.domain.profiling.UserOutlineRepository;
import org.neptrueworks.irishyperion.domain.verification.VerificationCredential;
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
                       VerificationCredential password, String username) {
        if (this.identityRepository.exists(identificationClaim)) {
            throw new IdentifierClaimedException(identificationClaim);
        }

        UserIdentifier userId = this.identifierGenerator.nextIdentifier();
        UserIdentity identity = this.identityFactory.create(eventPublisher, userId, identificationClaim);
        this.identityRepository.save(identity);

        UserAccount account = this.accountFactory.create(eventPublisher, userId, password);
        this.accountRepository.save(account);

        UserOutline outline = this.outlineFactory.create(eventPublisher, userId, username);
        this.outlineRepository.save(outline);

    }
}
