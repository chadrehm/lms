package com.learning.management;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@QuarkusTest
public class DatabaseIntegrationTest {

    @Inject
    EntityManager entityManager;

    @Test
    @Transactional
    public void testDatabaseConnection() {
        // Run a simple query to check the connection
        Long count = (Long) entityManager.createQuery("SELECT COUNT(*) FROM User").getSingleResult();

        // Assert that the database is connected by checking if the count is non-negative
        RestAssured.given()
                .when().get("/users") // Assumes an endpoint exists to fetch all users
                .then()
                .statusCode(200)
                .body("$.size()", greaterThan(0)); // Check that users exist
    }
}
