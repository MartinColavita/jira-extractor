package com.eldar.business.jiraextractor.api.exceptions.controllers;

import com.eldar.business.jiraextractor.api.exceptions.customs.NotFoundException;
import com.eldar.business.jiraextractor.utils.swaggerconf.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
public class NotFoundExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(NotFoundException ex, HttpServletRequest request){
        var response = ErrorResponse.builder()
                .code(org.springframework.http.HttpStatus.NOT_FOUND.value())
                .status(org.springframework.http.HttpStatus.NOT_FOUND.name())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.NOT_FOUND);
    }

}
