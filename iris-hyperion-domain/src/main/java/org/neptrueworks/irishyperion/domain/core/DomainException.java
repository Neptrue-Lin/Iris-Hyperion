package org.neptrueworks.irishyperion.domain.core;

public class DomainException extends RuntimeException{
    public DomainException() {}
    public DomainException(String message) {
        super(message);
    }
}
