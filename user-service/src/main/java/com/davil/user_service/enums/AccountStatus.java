package com.davil.user_service.enums;

public enum AccountStatus {
    
    PENDING,    // Waiting for verification
    ACTIVE,     // Verified and active
    SUSPENDED,  // Temporarily disabled
    REJECTED    // Application rejected
}
