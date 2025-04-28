package com.example.fufastorebemongo.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> generateSuccessResponse(String message, T data) {
        ApiResponse<T> response = new ApiResponse<T>(true, message, data, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> generateSuccessResponse(String message, T data,
            HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<T>(true, message, data, null);
        return new ResponseEntity<>(response, status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> generateErrorResponse(String message, Object errors) {
        ApiResponse<T> response = new ApiResponse<T>(false, message, null, errors);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<ApiResponse<T>> generateErrorResponse(String message, Object errors,
            HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<T>(false, message, null, errors);
        return new ResponseEntity<>(response, status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> generateSuccessResponseWithHeaders(String message, T data,
            HttpHeaders headers) {
        ApiResponse<T> response = new ApiResponse<>(true, message, data, null);
        return ResponseEntity.ok()
                .headers(headers)
                .body(response);
    }

}