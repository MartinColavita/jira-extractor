package com.eldar.business.jiraextractor.api.exceptions.customs;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }

}
