package com.davil.user_service.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email){
        super(email);
    }    
    
}
