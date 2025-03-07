package org.neptrueworks.irishyperion.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class JsonWebTokenPayload {
    private String issuer;
    private String subject;
    private String audience;
    private Date expiration;
    private Date notBefore;
    private Date issuedAt;
    private String id;
}
