package com.petproject.tech_blog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public interface ExceptionHandlerInterface {
    ResponseEntity<Object> handleException(Exception exception, WebRequest request);
}