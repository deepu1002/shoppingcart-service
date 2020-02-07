package com.mindtree.exception;

import com.mindtree.model.ErrorItem;
import com.mindtree.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
 
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException constraintViolationException) {
        log.error("ConstraintViolationException caused : ", constraintViolationException);
        ErrorResponse errors = new ErrorResponse();
        for (ConstraintViolation violation : constraintViolationException.getConstraintViolations()) {
            ErrorItem error = new ErrorItem();
            error.setCode(violation.getMessageTemplate());
            error.setMessage(violation.getMessage());
            errors.addError(error);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
 
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException resourceNotFoundException) {
        log.error("ResourceNotFoundException caused : ", resourceNotFoundException);
        ErrorItem error = new ErrorItem();
        error.setMessage(resourceNotFoundException.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorItem> handle(Exception exception) {
        log.error("Exception caused : ", exception);
        ErrorItem error = new ErrorItem();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}