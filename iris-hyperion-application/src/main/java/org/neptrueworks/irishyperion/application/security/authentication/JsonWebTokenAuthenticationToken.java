package org.neptrueworks.irishyperion.application.security.authentication;

import lombok.Getter;
import org.neptrueworks.irishyperion.application.security.authorization.JsonWebTokenAuthorizationCredential;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;

@Getter
public class JsonWebTokenAuthenticationToken extends AbstractAuthenticationToken {
    private JsonWebTokenAuthorizationCredential credential;
    private Object principal;

    public JsonWebTokenAuthenticationToken(Collection<? extends GrantedAuthority> authorities,
                                           JsonWebTokenAuthorizationCredential credential,
                                           Object principal) {
        super(authorities);
        this.credential = credential;
        this.principal = principal;
    }

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public JsonWebTokenAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    /**
     * The credentials that prove the principal is correct. This is usually a password,
     * but could be anything relevant to the <code>AuthenticationManager</code>. Callers
     * are expected to populate the credentials.
     *
     * @return the credentials that prove the identity of the <code>Principal</code>
     */
    @Override
    public JsonWebTokenAuthorizationCredential getCredentials() {
        return this.credential;
    }

    /**
     * The identity of the principal being authenticated. In the case of an authentication
     * request with username and password, this would be the username. Callers are
     * expected to populate the principal for an authentication request.
     * <p>
     * The <tt>AuthenticationManager</tt> implementation will often return an
     * <tt>Authentication</tt> containing richer information as the principal for use by
     * the application. Many of the authentication providers will create a
     * {@code UserDetails} object as the principal.
     *
     * @return the <code>Principal</code> being authenticated or the authenticated
     * principal after authentication.
     */
    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credential = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JsonWebTokenAuthenticationToken that = (JsonWebTokenAuthenticationToken) o;
        return Objects.equals(credential, that.credential) && Objects.equals(principal, that.principal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), credential, principal);
    }
}
