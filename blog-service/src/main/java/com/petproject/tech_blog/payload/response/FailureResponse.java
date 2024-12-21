package com.petproject.tech_blog.payload.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FailureResponse<T> extends ApiResponse<T> {
    public FailureResponse(T data) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failure", data);
    }
     // Static factory method for ResponseEntity
    public static <T> ResponseEntity<FailureResponse<T>> of(T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(new FailureResponse<>(data));
    }
}