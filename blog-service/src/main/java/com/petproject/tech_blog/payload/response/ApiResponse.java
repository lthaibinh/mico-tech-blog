package com.petproject.tech_blog.payload.response;


import lombok.Data;

@Data
public abstract class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
  

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
