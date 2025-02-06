package com.relatosdepapel.ms_books_catalog.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationException(ConstraintViolationException ex) {

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        StringBuilder errorMessages = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            errorMessages.append(violation.getMessage()).append(". ");
        }

        return new ResponseEntity<>(errorMessages.toString().trim(), HttpStatus.BAD_REQUEST);
    }
}
