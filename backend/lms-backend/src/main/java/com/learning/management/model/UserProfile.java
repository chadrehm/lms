package com.learning.management.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * The {@code UserProfile} represents a user’s profile information in the system. 
 * This entity stores basic user details such as their first name, last name, 
 * email address, and the timestamp when the profile was created.
 *
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code firstName}: The user's first name.</li>
 *   <li>{@code lastName}: The user's last name.</li>
 *   <li>{@code email}: The user's email address.</li>
 *   <li>{@code createdAt}: The timestamp indicating when the user profile was created.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>{@code getFullName()}: Returns the full name of the user by concatenating first and last names.</li>
 * </ul>
 */
@Entity
@Table(name = "user_profile")
public class UserProfile extends PanacheEntity {
    @Column(name= "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name= "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name= "email", nullable = false, length = 20)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Getters
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    // Getters
    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
