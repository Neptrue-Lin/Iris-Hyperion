package org.neptrueworks.irishyperion.application.security.authentication;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.application.security.authentication.exceptions.CredentialExpiredException;
import org.neptrueworks.irishyperion.application.security.authorization.JsonWebTokenAuthorizationCredential;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountCancelledException;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountDeletedException;
import org.neptrueworks.irishyperion.domain.accounting.exceptions.AccountLockedException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonWebTokenAuthenticationProvider implements AuthenticationProvider {
    private JsonWebTokenAuthenticationService authenticationService;

    /**
     * Performs authentication with the same contract as
     * {@link AuthenticationManager#authenticate(Authentication)}.
     *
     * @param authentication the authentication request object.
     * @return a fully authenticated object including credentials. May return
     * <code>null</code> if the <code>AuthenticationProvider</code> is unable to support
     * authentication of the passed <code>Authentication</code> object. In such a case,
     * the next <code>AuthenticationProvider</code> that supports the presented
     * <code>Authentication</code> class will be tried.
     * @throws AuthenticationException if authentication fails.
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(!(authentication.getCredentials() instanceof JsonWebTokenAuthorizationCredential credential))
            throw new BadCredentialsException("Bad credentials");

        try {
            this.authenticationService.authenticate(credential);
        }
        //Account
        catch (AccountLockedException e) {
            throw new LockedException(e.getLocalizedMessage(), e);
        } catch (AccountCancelledException | AccountDeletedException e) {
            throw new DisabledException(e.getLocalizedMessage(), e);
        }
        //Credential
        catch (CredentialExpiredException e) {
            throw new CredentialsExpiredException(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getLocalizedMessage(), e);
        }
        return authentication;
    }

    /**
     * Returns <code>true</code> if this <Code>AuthenticationProvider</code> supports the
     * indicated <Code>Authentication</code> object.
     *
     * @param authentication the authentication request instance.
     * @return <code>true</code> if the request instance is derived from <code>JsonWebTokenAuthenticationToken</code>.
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return JsonWebTokenAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
