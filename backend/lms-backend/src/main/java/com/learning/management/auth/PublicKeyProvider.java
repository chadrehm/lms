package com.learning.management.auth;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * Provides functionality for loading and decoding a public key from a PEM file.
 * This class is responsible for reading the public key file, removing the PEM headers and footers,
 * decoding the base64 content, and returning the public key in a usable format.
 */
public class PublicKeyProvider {
    private static final String PUBLIC_KEY_PATH = "/keys/public_key.pem"; // Set the path to your public key file

    /**
     * Loads the public key from the specified path, decodes it, and returns it as a PublicKey object.
     * The method expects the public key to be in PEM format and removes the PEM-specific headers and footers
     * before decoding the base64 content.
     *
     * @return the decoded PublicKey object
     * @throws Exception if an error occurs while loading or decoding the public key
     */
    public static PublicKey getPublicKey() throws Exception {
        // Load the public key file as a classpath resource
        InputStream inputStream = PublicKeyProvider.class.getResourceAsStream(PUBLIC_KEY_PATH);

        if (inputStream == null) {
            throw new IOException("Public key file not found at " + PUBLIC_KEY_PATH);
        }

        // Read the content of the public key file
        byte[] keyBytes = inputStream.readAllBytes();

        // Remove the first and last "-----BEGIN PUBLIC KEY-----" and "-----END PUBLIC KEY-----" lines
        String publicKeyContent = new String(keyBytes)
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")
            .replaceAll("\\s", "");  // Remove all spaces and newlines

        // Decode the base64 content
        byte[] decodedKey = java.util.Base64.getDecoder().decode(publicKeyContent);

        // Convert the decoded key into a PublicKey object
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);

        return keyFactory.generatePublic(keySpec);
    }
}
