package com.learning.management.repository;

import java.util.List;

import com.learning.management.model.Enrollment;
import com.learning.management.model.UserProfile;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnrollmentRepository implements PanacheRepository<Enrollment> {

    public List<UserProfile> getStudentsByClassId(Long classId) {
        return getEntityManager()
                .createQuery("SELECT up FROM Enrollment e JOIN e.student up JOIN e.enrolledClass c WHERE c.id = :classId", UserProfile.class)
                .setParameter("classId", classId)
                .getResultList();
    }
}
