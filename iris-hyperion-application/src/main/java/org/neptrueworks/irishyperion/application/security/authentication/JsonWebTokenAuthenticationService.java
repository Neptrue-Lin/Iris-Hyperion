package org.neptrueworks.irishyperion.application.security.authentication;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.application.security.authentication.exceptions.CredentialDeactivatedException;
import org.neptrueworks.irishyperion.application.security.authentication.exceptions.CredentialExpiredException;
import org.neptrueworks.irishyperion.application.security.authentication.exceptions.CredentialUnavailableException;
import org.neptrueworks.irishyperion.application.security.authorization.JsonWebTokenAuthorizationCredential;
import org.neptrueworks.irishyperion.application.security.authorization.JsonWebTokenAuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.accounting.UserAccount;
import org.neptrueworks.irishyperion.domain.accounting.UserAccountRepository;
import org.neptrueworks.irishyperion.domain.auth.AuthenticationService;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
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

        UserIdentifier userId = new UserIdentifier(token.getClaims().getSubject());
        UserAccount account = this.accountRepository.fetchByIdentifierOrError(userId);
        account.checkAccountLoggability();

        JsonWebTokenAuthorizationIdentifier authId = new JsonWebTokenAuthorizationIdentifier(token.getClaims().getId());
        if (token.getClaims().getIssuedAt() != null
                && token.getClaims().getIssuedAt().before(this.calendarService.currentDate()))
            throw new CredentialUnavailableException(userId, authId);
        if (token.getClaims().getNotBefore() != null
                && token.getClaims().getNotBefore().before(this.calendarService.currentDate()))
            throw new CredentialDeactivatedException(userId, authId);
        if (token.getClaims().getExpiration() != null
                && this.calendarService.currentDate().after(token.getClaims().getExpiration()))
            throw new CredentialExpiredException(userId, authId);
    }
}
