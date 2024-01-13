package com.eldar.business.hirenhub.api.exceptions.customs;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message) {
        super(message);
    }
}
