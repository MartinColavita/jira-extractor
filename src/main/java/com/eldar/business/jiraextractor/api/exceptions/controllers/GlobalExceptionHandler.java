package com.eldar.business.jiraextractor.api.exceptions.controllers;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.api.exceptions.customs.NotFoundException;
import com.eldar.business.jiraextractor.utils.swaggerconf.ErrorResponse;
import com.eldar.business.jiraextractor.utils.swaggerconf.ErrorResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> processRuntimeException(Exception ex, HttpServletRequest request) {
        ResponseEntity.BodyBuilder builder;
        ErrorResponse errorResponse;
        builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponse = ErrorResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .message("An unexpected error occurred")
                .path(request.getRequestURI())
                .build();

        return builder.body(errorResponse);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(NotFoundException ex, HttpServletRequest request) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.NOT_FOUND);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return builder.body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponses> badRequestExceptionHandler(BadRequestException ex, HttpServletRequest request) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        ErrorResponses errorResponses = ErrorResponses.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .messages(ex.getMessages())
                .path(request.getRequestURI())
                .build();

        return builder.body(errorResponses);
    }
}
