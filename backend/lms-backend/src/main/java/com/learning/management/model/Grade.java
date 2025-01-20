package com.learning.management.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents a grade assigned to a student for a specific enrollment in a class.
 * A grade is linked to an enrollment and records the assigned grade and creation timestamp.
 * 
 * <p>Relationships:</p>
 * <ul>
 *   <li>Many-to-one relationship with {@link Enrollment} for the student's enrollment details.</li>
 * </ul>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code grade}: The assigned grade, represented as a two-character string.</li>
 *   <li>{@code createdAt}: The timestamp indicating when the grade was created.</li>
 * </ul>
 */
@Entity
public class Grade extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    @Column(length = 2)
    private String grade;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Getters
    public Enrollment getEnrollment() {
        return enrollment;
    }

    public String getGrade() {
        return grade;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
