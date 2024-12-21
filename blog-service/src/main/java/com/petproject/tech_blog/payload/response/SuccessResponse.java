package com.petproject.tech_blog.payload.response;

import org.springframework.http.ResponseEntity;

public class SuccessResponse<T> extends ApiResponse<T> {
    public SuccessResponse(T data) {
        super(200, "Success", data);
    }
     // Static factory method for ResponseEntity
    public static <T> ResponseEntity<SuccessResponse<T>> of(T data) {
        return ResponseEntity.ok(new SuccessResponse<>(data));
    }

}