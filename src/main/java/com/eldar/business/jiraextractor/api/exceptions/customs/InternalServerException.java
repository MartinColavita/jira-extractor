package com.eldar.business.jiraextractor.api.exceptions.customs;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message) {
        super(message);
    }
}
