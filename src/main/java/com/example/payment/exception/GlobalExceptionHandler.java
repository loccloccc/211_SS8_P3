package com.example.payment.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> handleRuntime(
            RuntimeException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("error", exception.getMessage());

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidation(
            MethodArgumentNotValidException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put(
                "error",
                exception.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage()
        );

        return response;
    }
}