package com.learning.management.service;

import java.util.List;

import com.learning.management.model.UserProfile;
import com.learning.management.repository.UserProfileRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * {@code UserProfileService} provides business logic for managing user profiles.
 * It acts as a service layer that interacts with the {@link UserProfileRepository} 
 * to fetch, manipulate, and process data related to user profiles.
 */
@ApplicationScoped
public class UserProfileService {

    @Inject
    UserProfileRepository userRepository;

    /**
     * Retrieves all user profiles from the database.
     *
     * <p>This method fetches all user profiles stored in the database by delegating 
     * the call to the {@link UserProfileRepository}.</p>
     *
     * @return A {@link List} of {@link UserProfile} objects representing all users.
     */
    public List<UserProfile> findAllUsers() {
        return userRepository.findAllUsers();
    }

    /**
     * Finds user profiles by their role.
     *
     * <p>This method fetches all user profiles that have the specified role by 
     * delegating the query to the {@link UserProfileRepository}.</p>
     *
     * @param role The role to filter users by.
     * @return A {@link List} of {@link UserProfile} objects that match the given role.
     */
    public List<UserProfile> findUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
}
