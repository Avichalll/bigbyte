package com.davil.user_service.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.davil.user_service.exception.DuplicateEmailException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exp) {
                Map<String, String> validationErrors = new HashMap<>();
                exp.getBindingResult().getFieldErrors().forEach(error -> {
                        validationErrors.put(error.getField(), error.getDefaultMessage());
                });
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                                ExceptionResponse.builder()
                                                .validationErrors(validationErrors.entrySet().stream()
                                                                .map(entry -> entry.getKey() + ": " + entry.getValue())
                                                                .collect(Collectors.toSet()))
                                                .build());
        }

        @ExceptionHandler(DuplicateEmailException.class)
        public ResponseEntity<ExceptionResponse> handleException(DuplicateEmailException exp) {

                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                                ExceptionResponse.builder()
                                                .businessErrorDescription("Email already in use")
                                                .error(exp.getMessage()+ "already in use")
                                                .build());
        }


}
