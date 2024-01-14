package com.eldar.business.jiraextractor.api.exceptions.controllers;

import com.eldar.business.jiraextractor.api.exceptions.customs.InternalServerException;
import com.eldar.business.jiraextractor.utils.swaggerconf.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerExceptionController {
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> internalServerExceptionHandler(InternalServerException ex, HttpServletRequest request){
        var response = ErrorResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
