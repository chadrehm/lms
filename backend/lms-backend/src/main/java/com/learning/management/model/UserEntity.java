package com.learning.management.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * The {@code UserEntity} represents a user in the system's authentication database.
 * This entity stores information required for user authentication, including the 
 * username, hashed password, role, login status, and account activity.
 *
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code username}: The unique username associated with the user, used for login.</li>
 *   <li>{@code password}: The hashed password used for authentication.</li>
 *   <li>{@code role}: The role of the user (e.g., "admin", "user").</li>
 *   <li>{@code lastLogin}: The timestamp indicating the last time the user logged in.</li>
 *   <li>{@code isActive}: A flag indicating whether the user account is active.</li>
 *   <li>{@code createdAt}: The timestamp indicating when the user was created in the system.</li>
 * </ul>
 */
@Entity
@Table(name = "user_auth")
public class UserEntity extends PanacheEntity {

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 20)
    private String role;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
