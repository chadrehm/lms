package com.learning.management.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents a class in the learning management system.
 * Each class is associated with a teacher and contains metadata such as the class name and creation time.
 */
@Entity
public class Class extends PanacheEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private UserProfile teacher;  // This assumes that `teacher` is a `User` entity.

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Getters
    public String getName() {
        return name;
    }

    public UserProfile getTeacher() {
        return teacher;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(UserProfile teacher) {
        this.teacher = teacher;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
