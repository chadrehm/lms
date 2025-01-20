package com.learning.management.auth;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.learning.management.model.UserEntity;
import com.learning.management.service.UserService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Service for handling user login functionality.
 * Provides methods for authenticating users, validating passwords,
 * and generating JWT tokens for authenticated users.
 */
@ApplicationScoped
public class LoginService {
    @Inject
    @Named("userService")
    UserService userService; // Interface to get user details from Postgres, LDAP, etc.
    
    @Inject
    JwtTokenProvider jwtTokenProvider;

    /**
     * Authenticates the user by validating the provided username and password.
     * 
     * @param username the username of the user
     * @param password the password provided by the user
     * @return a JWT token if authentication is successful
     * @throws Exception if authentication fails or an internal error occurs
     */
    public String authenticate(String username, String password) throws Exception {
        Optional<UserEntity> userOpt = userService.findByUsername(username);
        
        if (!userOpt.isPresent()) {
            throw new RuntimeException();
        }

        UserEntity user = userOpt.get();


        if (isPasswordValid(user, password)) {
            return generateToken(user); // Return JWT or whatever token you're using
        } else {
            throw new Exception("Internal server error");
        }
    }

    /**
     * Validates the provided password by comparing it with the stored password hash.
     * 
     * @param user the user entity containing the stored password hash
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     */
    public boolean isPasswordValid(UserEntity user, String password) {
        return BCrypt.checkpw(password, user.getPassword());
    }

    /**
     * Generates a hashed version of the provided password using BCrypt.
     * 
     * @param password the password to hash
     * @return the hashed password
     */
    public String generatePasswordHash(String password) {
        int cost = 10; // Adjust the cost factor as needed (default is 10)
        String salt = BCrypt.gensalt(cost);
        return BCrypt.hashpw(password, salt);
    }

    /**
     * Generates a JWT token for the given user.
     * 
     * @param user the authenticated user for whom the token is generated
     * @return the generated JWT token
     * @throws Exception if an error occurs during token generation
     */
    private String generateToken(UserEntity user) throws Exception{
        jwtTokenProvider = new JwtTokenProvider();
        return jwtTokenProvider.generateToken(user);  // Generate JWT token using JwtTokenProvider
    }
}
