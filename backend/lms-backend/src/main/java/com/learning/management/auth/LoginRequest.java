package com.learning.management.auth;

/**
 * Represents a request to log in to the system, containing the user's credentials.
 * This class is used to capture the username and password submitted by the user during login.
 */
public class LoginRequest {
    private String username;
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    
}
