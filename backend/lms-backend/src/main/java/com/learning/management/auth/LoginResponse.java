package com.learning.management.auth;

/**
 * Represents the response returned after a successful login.
 * This class contains the JWT token that is issued to the user upon successful authentication.
 */
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }
}
