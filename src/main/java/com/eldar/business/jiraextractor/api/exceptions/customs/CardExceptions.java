package com.eldar.business.jiraextractor.api.exceptions.customs;

public class CardExceptions extends RuntimeException{
    public CardExceptions(String message) {
        super(message);
    }

    public CardExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
