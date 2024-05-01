package com.improveskillcoach.controllers.handlers;

import com.improveskillcoach.dto.CustomError;
import com.improveskillcoach.dto.ValidationError;
import com.improveskillcoach.services.exceptions.BusinessException;
import com.improveskillcoach.services.exceptions.DateTimeParseException;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<CustomError> invalidData(DateTimeParseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Invalid date format", request.getRequestURI());

        // Add the error message from the exception to the ValidationError object
        err.addError("field of data", e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomError> handleBusinessException(BusinessException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Inappropriate data!", request.getRequestURI());

        // Add the error message from the exception to the ValidationError object
        err.addError("field of data", e.getMessage());

        return ResponseEntity.status(status).body(err);
    }
}
