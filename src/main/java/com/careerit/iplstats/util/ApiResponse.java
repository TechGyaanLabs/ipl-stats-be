package com.careerit.iplstats.util;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private Instant timestamp;


    public ApiResponse(T data) {
        this.data = data;
        this.success = data != null;
        this.timestamp = Instant.now() ;
    }

    public ApiResponse<T> success(boolean success) {
        this.success = success;
        return this;
    }

    public ApiResponse<T> message(String message) {
        this.message = message;
        return this;
    }




}