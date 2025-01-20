package com.learning.management.auth;

import com.learning.management.auth.exceptions.ErrorResponse;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Controller for handling login requests.
 * Provides an endpoint for users to authenticate by providing their username and password.
 * The controller ensures that username enumeration attacks are mitigated by returning generic error messages.
 */
@Path("/login")
public class LoginController {
    @Inject
    LoginService loginService;

    /**
     * Authenticates a user based on the provided login credentials.
     * If the credentials are valid, a JWT token is returned.
     * If invalid, a generic error message is sent to avoid exposing specific user information.
     * 
     * @param loginRequest the login request containing the username and password
     * @return a Response containing the authentication result, either a token or an error message
     * @throws Exception if there is an internal error during the authentication process
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) throws Exception {
        try {
            // Authenticate the user and generate a JWT token
            String token = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            return Response.ok(new LoginResponse(token)).build();
        } catch (RuntimeException e) {
            // Return a generic error response to avoid leaking information about valid usernames
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new ErrorResponse("Invalid username or password"))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse("Internal server error"))
                    .build();
        }
    }
}
