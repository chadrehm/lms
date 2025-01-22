# IA-2: Identification and Authentication (Organizational Users)

## Objective
**Purpose:** Ensure that users are properly authenticated before gaining access to the system.

## Implementation Details
- **Description:**  
  Authentication is performed using a combination of username and password. Passwords are hashed using BCrypt, and the system generates JWT tokens upon successful login.  
- **Technology:**  
  - **Authentication:** Quarkus and `JwtTokenProvider`.  
  - **Password Hashing:** BCrypt in the `user_auth` table.

## Testing/Verification
- **How to Test:**  
  - Test login with valid and invalid credentials.  
  - Verify JWT token is generated for successful login and denied for invalid credentials.  
- **Logs to Check:**  
  - Audit logs for login success or failure.

## Related Controls
- AC-2: Account Management  
- AC-6: Least Privilege
