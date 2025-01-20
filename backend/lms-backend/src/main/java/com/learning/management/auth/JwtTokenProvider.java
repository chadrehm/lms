package com.learning.management.auth;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.time.Duration;

import com.learning.management.model.UserEntity;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Provides functionality for generating and managing JWT tokens.
 * This class handles creating JWT tokens for authenticated users, including the user's username, roles, and expiration time.
 * It uses a private key to sign the token and provides a method to retrieve the corresponding public key for token validation.
 */
@ApplicationScoped
public class JwtTokenProvider {

    private static final String ISSUER = "lms-app";
    private static final long EXPIRATION_TIME = Duration.ofHours(1).toMillis();  // Token expiration time (1 hour)

    /**
     * Generates a JWT token for the specified user.
     * The token includes the user's username, roles, issuer, and an expiration time.
     * The token is signed using the private key.
     *
     * @param user the user for whom the token is being generated
     * @return a signed JWT token
     * @throws Exception if an error occurs while generating the token, such as issues with the private key
     */
    public String generateToken(UserEntity user) throws Exception {
        try {
            PrivateKey privateKey = PrivateKeyProvider.getPrivateKey();

            return Jwt.claims()
                .issuer(ISSUER)
                .subject(user.getUsername())
                .groups(user.getRole())  // Attach user roles to the token
                .expiresAt(System.currentTimeMillis() + EXPIRATION_TIME)  // Set expiration time
                .sign(privateKey);  // Sign the token with the private key

        } catch (IOException e) {
            throw new RuntimeException("Error loading private key: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error processing private key: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error generating token: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves the public key used to validate the JWT token.
     * The public key is needed to verify the authenticity of the JWT token on the server side.
     *
     * @return the public key used for token verification
     * @throws Exception if an error occurs while retrieving the public key
     */
    public PublicKey getPublicKey() throws Exception {
        return PublicKeyProvider.getPublicKey();  // You would need to implement this method
    }
}
