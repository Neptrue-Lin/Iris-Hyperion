package org.neptrueworks.irishyperion.application.security.authorization;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.auth.TokenizableAuthorizationCredential;

import javax.crypto.SecretKey;

@Getter
public class JsonWebTokenAuthorizationCredential extends TokenizableAuthorizationCredential {
    private static final SecretKey KEY = null;
    private final Claims claims;
    private final CharSequence credential;

    public JsonWebTokenAuthorizationCredential(Claims claims) {
        this.claims = claims;
        this.credential = this.tokenize();
    }

    public static JsonWebTokenAuthorizationCredential parse(CharSequence credential) {
        Jwt<Header, Claims> parsedToken = Jwts.parser().decryptWith(JsonWebTokenAuthorizationCredential.KEY)
                .build().parseUnsecuredClaims(credential);
        return new JsonWebTokenAuthorizationCredential(parsedToken.getPayload());
    }

    @Override
    protected CharSequence tokenize() {
        return Jwts.builder().claims().add(this.getClaims())
                .and().signWith(JsonWebTokenAuthorizationCredential.KEY)
                .compact();
    }
}
