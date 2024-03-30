package org.neptrueworks.irishyperion.domain.auth.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenAuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenAuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.auth.exceptions.AuthorizationCredentialDeactivatedException;
import org.neptrueworks.irishyperion.domain.auth.exceptions.AuthorizationCredentialExpiredException;
import org.neptrueworks.irishyperion.domain.auth.exceptions.AuthorizationCredentialUnavailableException;
import org.neptrueworks.irishyperion.domain.chrono.CalendarService;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonWebTokenAuthenticationService extends AuthenticationService {
    private CalendarService calendarService;
    private UserAccountRepository accountRepository;

    @Override
    public void authenticate(AuthorizationCredential credential) {
        if (credential == null)
            throw new NullPointerException();
        if (!(credential instanceof JsonWebTokenAuthorizationCredential token))
            throw new IllegalArgumentException();

        UserIdentifier userId = new UserIdentifier(token.getPayload().getSubject());
        UserAccount account = this.accountRepository.fetchByIdentifierOrError(userId);
        account.checkAccountLoggability();

        JsonWebTokenAuthorizationIdentifier authId = new JsonWebTokenAuthorizationIdentifier(token.getPayload().getId());
        if (token.getPayload().getIssuedAt() != null
                && token.getPayload().getIssuedAt().before(this.calendarService.currentDate()))
            throw new AuthorizationCredentialUnavailableException(userId, authId);
        if (token.getPayload().getNotBefore() != null
                && token.getPayload().getNotBefore().before(this.calendarService.currentDate()))
            throw new AuthorizationCredentialDeactivatedException(userId, authId);
        if (token.getPayload().getExpiration() != null
                && this.calendarService.currentDate().after(token.getPayload().getExpiration()))
            throw new AuthorizationCredentialExpiredException(userId, authId);
    }
}
