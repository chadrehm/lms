# AC-6: Least Privilege

## Objective
**Purpose:** Restrict user access to the minimum privileges necessary to perform their roles and responsibilities.

## Implementation Details
- **Description:**  
  Role-based access control (RBAC) ensures each user can only access endpoints relevant to their role. Quarkus annotations enforce RBAC logic during runtime.  
- **Technology:**  
  - **Application Layer:** Quarkus security annotations for role validation.  
  - **Middleware:** Custom access validation middleware.  
  - **Database:** Role field in `user_auth` table.

## Testing/Verification
- **How to Test:**  
  - Verify that students cannot access class management endpoints (`teacher` only).  
  - Check that parents can only view their children's enrollment and grades.  
- **Logs to Check:**  
  - Authorization failures in application logs.

## Related Controls
- AC-2: Account Management  
- AU-2: Audit Events
