package com.learning.management.controller;

import java.util.List;

import com.learning.management.model.UserProfile;
import com.learning.management.repository.EnrollmentRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

@Path("/classes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClassController {

    @Inject
    EnrollmentRepository enrollmentRepository;

    @GET
    @Path("/{classId}/students")
    public List<UserProfile> getStudentsByClass(@PathParam("classId") Long classId) {
        if (classId <= 0) {
            throw new WebApplicationException("Invalid class ID", 400);
        }
        return enrollmentRepository.getStudentsByClassId(classId);
    }
}
