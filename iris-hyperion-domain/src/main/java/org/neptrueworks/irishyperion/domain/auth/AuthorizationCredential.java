package org.neptrueworks.irishyperion.domain.auth;

import java.io.Serializable;

public abstract class AuthorizationCredential implements Serializable {
    public abstract String getCredential();
}
