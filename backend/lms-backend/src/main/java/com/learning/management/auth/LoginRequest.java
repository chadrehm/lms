package com.learning.management.auth;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Represents a request to log in to the system, containing the user's credentials.
 * This class is used to capture the username and password submitted by the user during login.
 */
public class LoginRequest {
    private String username;
    private String password;
    
    @NotNull(message = "Username cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9._-]{5,19}$", message = "Username must be between 6-20 characters and can only contain letters, numbers, '.', '_', and '-'")
    public String getUsername() {
        return username;
    }
    
    @NotNull(message = "Password cannot be null")
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean validateUsername(String username) {
        String usernamePattern = "^[a-zA-Z0-9][a-zA-Z0-9._-]{5,19}$";  // 6-20 characters, starts with a letter or number
        return username != null && username.matches(usernamePattern);
    }
    
}
