package com.learning.management.repository;

import java.util.List;

import com.learning.management.model.UserProfile;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * {@code UserProfileRepository} is a repository class responsible for handling 
 * data access operations related to {@link UserProfile}. It extends {@link PanacheRepository} 
 * to provide methods for interacting with the database using the Panache ORM.
 */
@ApplicationScoped
public class UserProfileRepository implements PanacheRepository<UserProfile> {

    /**
     * Finds all {@link UserProfile} entities in the database.
     *
     * <p>This method retrieves all user profiles stored in the database.</p>
     *
     * @return A {@link List} of all {@link UserProfile} entities.
     */
    public List<UserProfile> findAllUsers() {
        return findAll().list();
    }

    /**
     * Finds {@link UserProfile} entities by their role.
     *
     * <p>This method queries the database for user profiles that match the specified role.</p>
     *
     * @param role The role of the users to search for.
     * @return A {@link List} of {@link UserProfile} entities with the specified role.
     */
    public List<UserProfile> findByRole(String role) {
        return find("role", role).list();
    }
}
