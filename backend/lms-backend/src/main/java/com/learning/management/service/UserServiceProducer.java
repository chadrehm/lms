package com.learning.management.service;

import com.learning.management.repository.PostgresUserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * {@code UserServiceProducer} is responsible for producing an instance of {@link UserService} for dependency injection.
 * The {@link UserServiceProducer} uses the {@link PostgresUserRepository} to provide an implementation of {@link UserService}, 
 * which is injected wherever {@code UserService} is needed in the application.
 */
@ApplicationScoped
public class UserServiceProducer {

    @Inject
    PostgresUserRepository postgresUserRepository; 
    
    @Produces
    @ApplicationScoped
    @Named("userService")
    public UserService produceUserRepository() {
        return postgresUserRepository;
    }
}

