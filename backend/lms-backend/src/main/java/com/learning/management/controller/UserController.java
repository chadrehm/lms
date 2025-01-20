package com.learning.management.controller;

import java.util.List;

import com.learning.management.model.UserProfile;
import com.learning.management.service.UserProfileService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * REST controller for managing user profiles.
 * This controller provides endpoints to retrieve user-related data.
 */
@Path("/users")
public class UserController {

    @Inject
    UserProfileService userService;

    /**
     * Retrieves a list of all user profiles.
     * 
     * @return a list of {@link UserProfile} objects representing all users in the system
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserProfile> findUsers() {
        return userService.findAllUsers();
    }
}
