package com.learning.management.repository;

import java.util.Optional;

import com.learning.management.model.UserEntity;
import com.learning.management.service.UserService;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * {@code PostgresUserRepository} is a repository class responsible for handling 
 * data access operations related to {@link UserEntity} in a PostgreSQL database.
 * This class leverages the PanacheRepository to simplify the interaction with the database 
 * and implements {@link UserService} to provide user-related services.
 */
@ApplicationScoped
public class PostgresUserRepository implements PanacheRepository<UserEntity>, UserService {

    /**
     * Finds a {@link UserEntity} by its {@code username}.
     *
     * <p>This method queries the database for a user with the specified username.</p>
     *
     * @param username The username to search for.
     * @return An {@link Optional} containing the {@link UserEntity} if found, otherwise {@link Optional#empty()}.
     */
    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return Optional.ofNullable(find("username", username).firstResult());
    }
}
