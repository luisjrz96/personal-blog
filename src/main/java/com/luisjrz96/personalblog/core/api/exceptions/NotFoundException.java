package com.luisjrz96.personalblog.core.api.exceptions;

public class NotFoundException extends RuntimeException {
    public static final String NOT_FOUND = "%s with id %s was not found";


    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(String resourceName, String id) {
        super(String.format(NOT_FOUND, resourceName, id));
    }
}
