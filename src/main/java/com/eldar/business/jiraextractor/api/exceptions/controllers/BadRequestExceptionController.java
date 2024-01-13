package com.eldar.business.jiraextractor.api.exceptions.controllers;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.utils.swaggerconf.ErrorResponses;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExceptionController {

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponses> badRequestExceptionHandler(BadRequestException e, HttpServletRequest request){
        var response = ErrorResponses.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .timestamp(LocalDateTime.now())
                .messages(e.getMessages())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
