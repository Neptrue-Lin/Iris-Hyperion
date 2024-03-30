package org.neptrueworks.irishyperion.domain.common;

public class DomainException extends RuntimeException {
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
