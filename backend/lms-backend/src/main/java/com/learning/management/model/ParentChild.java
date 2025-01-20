package com.learning.management.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The {@code ParentChild} entity represents the relationship between a parent and a child in the system.
 * This relationship is modeled as a many-to-one relationship between the parent and child, both of which are represented as 
 * {@link UserProfile} entities.
 *
 * <p>Relationships:</p>
 * <ul>
 *   <li>Many-to-one relationship with {@link UserProfile} for the parent.</li>
 *   <li>Many-to-one relationship with {@link UserProfile} for the child.</li>
 * </ul>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code parent}: The parent {@link UserProfile} entity.</li>
 *   <li>{@code child}: The child {@link UserProfile} entity.</li>
 * </ul>
 */
@Entity
public class ParentChild extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private UserProfile parent;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private UserProfile child;

    // Getters
    public UserProfile getParent() {
        return parent;
    }

    public UserProfile getChild() {
        return child;
    }

    // Setters
    public void setParent(UserProfile parent) {
        this.parent = parent;
    }

    public void setChild(UserProfile child) {
        this.child = child;
    }
}
