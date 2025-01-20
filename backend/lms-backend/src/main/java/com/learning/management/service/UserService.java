package com.learning.management.service;

import java.util.Optional;

import com.learning.management.model.UserEntity;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * {@code UserService} defines the contract for services managing user authentication and profile retrieval.
 * This interface exposes a method for finding a user by their username. Implementations of this interface
 * are responsible for interacting with data sources, such as databases, to perform the necessary operations.
 */
@ApplicationScoped
public interface UserService {
    Optional<UserEntity> findByUsername(String username);
}
