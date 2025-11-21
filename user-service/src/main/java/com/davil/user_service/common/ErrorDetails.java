package com.davil.user_service.common;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {
    
    private String code;              // Error code (e.g., "USER_NOT_FOUND")
    private String message;           // Human-readable error message
    private List<FieldError> fieldErrors; // Validation errors
    private String path;              // API endpoint that failed
    private Map<String, Object> metadata; // Additional context
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FieldError {
        private String field;
        private String message;
        private Object rejectedValue;
    }
}