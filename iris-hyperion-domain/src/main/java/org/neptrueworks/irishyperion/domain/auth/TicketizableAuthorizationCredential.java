package org.neptrueworks.irishyperion.domain.auth;

public abstract class TicketizableAuthorizationCredential extends AuthorizationCredential {
    protected abstract byte[] ticketize();
}
