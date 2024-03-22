package org.neptrueworks.irishyperion.domain.auth;

public abstract class TokenizableAuthorizationCredential extends AuthorizationCredential {
    protected abstract CharSequence tokenize();
}
