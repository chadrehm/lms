package com.learning.management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.learning.management.auth.LoginService;
import com.learning.management.model.UserEntity;

class LoginServiceTest {

    private final LoginService loginService = new LoginService();

    @Test
    void testPasswordEncryptionAndValidation() {
        String password = "password123";

        // Generate the bcrypt hash
        String hashedPassword = loginService.generatePasswordHash(password);

        // Mock user entity for validation
        UserEntity user = new UserEntity();
        user.setPassword(hashedPassword);

        // Validate password with the generated hash
        boolean isValid = loginService.isPasswordValid(user, password);
        
        // Assert the password is valid
        assertTrue(isValid);
        
        // Test with an incorrect password
        boolean isInvalid = loginService.isPasswordValid(user, "wrongPassword");
        
        // Assert the password is invalid
        assertFalse(isInvalid);
    }
}

