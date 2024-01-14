package com.eldar.business.jiraextractor.api.exceptions.customs;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException{
    private String[] messages;
    public BadRequestException(String[] messages) {
        super();
        this.messages = messages;
    }
}
