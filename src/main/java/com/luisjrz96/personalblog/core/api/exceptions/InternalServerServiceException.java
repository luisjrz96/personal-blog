package com.luisjrz96.personalblog.core.api.exceptions;

public class InternalServerServiceException extends RuntimeException{
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

    public InternalServerServiceException(Throwable throwable) {
        super(INTERNAL_SERVER_ERROR, throwable);
    }
}
