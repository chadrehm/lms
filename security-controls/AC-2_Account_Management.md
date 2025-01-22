# AC-2: Account Management

## Objective
**Purpose:** Ensure only authorized users have access to the system and their access aligns with their role.

## Implementation Details
- **Description:**  
  User roles (`parent`, `student`, `teacher`) are stored in the `user_auth` table. Role-based access is enforced via middleware in the Quarkus application to ensure least privilege.  
- **Technology:**  
  - **Database:** Postgres (`user_auth` table).  
  - **Application Layer:** Quarkus with role-based security annotations (`@RolesAllowed`).  
  - **Password Hashing:** BCrypt.

## Testing/Verification
- **How to Test:**  
  - Attempt to log in with invalid credentials and verify failure.  
  - Attempt to access teacher-only endpoints with a `student` role and confirm access is denied.  
  - Verify database entries for role assignment are accurate.  
- **Logs to Check:**  
  - Audit logs for successful and failed login attempts.

## Related Controls
- AC-6: Least Privilege  
- IA-2: Identification and Authentication (Organizational Users)
