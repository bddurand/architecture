package com.bdurand.msposts.service.exception;

public class ExternalServiceException  extends RuntimeException{
    public ExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExternalServiceException(String message) {
        super(message);
    }
}