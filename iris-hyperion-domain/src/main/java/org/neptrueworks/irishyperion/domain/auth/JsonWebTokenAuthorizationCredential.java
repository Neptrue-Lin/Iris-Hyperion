package org.neptrueworks.irishyperion.domain.auth;

import lombok.Getter;
import org.neptrueworks.irishyperion.domain.auth.services.JsonWebTokenTokenizationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKey;

@Getter
public class JsonWebTokenAuthorizationCredential extends TokenizableAuthorizationCredential {
    private static final SecretKey KEY = null;
    private final JsonWebTokenPayload payload;
    private final CharSequence credential;
    private final JsonWebTokenTokenizationService service;


    public JsonWebTokenAuthorizationCredential(JsonWebTokenPayload payload, @Autowired JsonWebTokenTokenizationService service) {
        this.payload = payload;
        this.credential = this.tokenize();
        this.service = service;
    }

    @Override
    protected CharSequence tokenize() {
        return this.service.tokenize(JsonWebTokenAuthorizationCredential.KEY, this.payload);
    }
}
