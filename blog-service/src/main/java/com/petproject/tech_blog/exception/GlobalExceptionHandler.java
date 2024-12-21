package com.petproject.tech_blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// Step 2: Create a Default Implementation for the Interface
@Component
class DefaultExceptionHandler implements ExceptionHandlerInterface {
    @Override
    public ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", exception.getMessage());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// Step 3: Create a Custom Exception Handler Implementation (Optional)

class CustomExceptionHandler implements ExceptionHandlerInterface {
    @Override
    public ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Custom Error");
        response.put("message", exception.getMessage());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private final ExceptionHandlerInterface exceptionHandler;

    public GlobalExceptionHandler(ExceptionHandlerInterface exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        return exceptionHandler.handleException(exception, request);
    }

}