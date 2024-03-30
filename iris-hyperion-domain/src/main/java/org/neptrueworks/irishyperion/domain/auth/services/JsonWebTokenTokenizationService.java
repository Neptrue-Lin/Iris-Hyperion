package org.neptrueworks.irishyperion.domain.auth.services;

import org.neptrueworks.irishyperion.domain.auth.JsonWebTokenPayload;

import javax.crypto.SecretKey;

public interface JsonWebTokenTokenizationService {
    CharSequence tokenize(SecretKey key, JsonWebTokenPayload payload);
}
