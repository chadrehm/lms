package com.learning.management.auth;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Provides functionality for loading and decoding a private key from a PEM file.
 * This class is responsible for reading the private key file, removing the PEM headers and footers,
 * decoding the base64 content, and returning the private key in a usable format.
 */
public class PrivateKeyProvider {
    private static final String PRIVATE_KEY_PATH = "/keys/private_key.pem"; // Set the path to your private key file

    /**
     * Loads the private key from the specified path, decodes it, and returns it as a PrivateKey object.
     * The method expects the private key to be in PEM format and removes the PEM-specific headers and footers
     * before decoding the base64 content.
     *
     * @return the decoded PrivateKey object
     * @throws Exception if an error occurs while loading or decoding the private key
     */
    public static PrivateKey getPrivateKey() throws Exception {
        // Load the private key file as a classpath resource
        InputStream inputStream = PrivateKeyProvider.class.getResourceAsStream(PRIVATE_KEY_PATH);
        
        if (inputStream == null) {
            throw new IOException("Private key file not found at " + PRIVATE_KEY_PATH);
        }

        // Read the content of the private key file
        byte[] keyBytes = inputStream.readAllBytes();
        
        // Remove the first and last "-----BEGIN PRIVATE KEY-----" and "-----END PRIVATE KEY-----" lines
        String privateKeyContent = new String(keyBytes)
            .replace("-----BEGIN PRIVATE KEY-----", "")
            .replace("-----END PRIVATE KEY-----", "")
            .replaceAll("\\s", "");  // Remove all spaces and newlines

        // Decode the base64 content
        byte[] decodedKey = java.util.Base64.getDecoder().decode(privateKeyContent);

        // Convert the decoded key into a PrivateKey object
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        
        return keyFactory.generatePrivate(keySpec);
    }
}
