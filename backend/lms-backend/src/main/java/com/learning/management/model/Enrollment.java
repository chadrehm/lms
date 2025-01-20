package com.learning.management.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents an enrollment entity that links a student to a specific class.
 * Each enrollment corresponds to a student enrolled in a class.
 *  
 * <p>Relationships:</p>
 * <ul>
 *   <li>Many-to-one relationship with {@link UserProfile} for the student.</li>
 *   <li>Many-to-one relationship with {@link Class} for the enrolled class.</li>
 * </ul>
 */
@Entity
public class Enrollment extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private UserProfile student;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class enrolledClass;

    // Getters 
    public Long getId() {
        return id;
    }

    public UserProfile getStudent() {
        return student;
    }

    public Class getEnrolledClass() {
        return enrolledClass;
    }
    
    // Setters
    public void setStudent(UserProfile student) {
        this.student = student;
    }

    public void setEnrolledClass(Class enrolledClass) {
        this.enrolledClass = enrolledClass;
    }
}
