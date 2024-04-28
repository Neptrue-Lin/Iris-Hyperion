package org.neptrueworks.irishyperion.domain.auth.services;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.AuthorizationIdentifier;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenAuthorizationCredential;
import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenPayload;
import org.neptrueworks.irishyperion.domain.chrono.CalendarService;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonWebTokenAuthorizationService extends AuthorizationService {
    private final JsonWebTokenTokenizationService tokenizationService;
    private final CalendarService calendarService;

    @Override
    public AuthorizationCredential authorize(UserIdentifier userId, AuthorizationIdentifier identifier) {
        //TODO JWT expiration issuer audience
        JsonWebTokenPayload payload = JsonWebTokenPayload.builder()
                .id(identifier.getIdentifier())
                .subject(userId.identifier())
                .notBefore(this.calendarService.currentDate())
                .issuedAt(this.calendarService.currentDate())
                .build();
        return new JsonWebTokenAuthorizationCredential(payload, this.tokenizationService);
    }
}
