# AC-7: Unsuccessful Login Attempts

## Objective
**Purpose:** Prevent brute force attacks by locking accounts temporarily after repeated failed login attempts.

## Implementation Details
- **Description:**  
  A failed login counter is tracked for each user in the `user_auth` table. Accounts are locked temporarily after a configurable threshold (e.g., 5 attempts). Locked accounts are automatically unlocked after a timeout.  
- **Technology:**  
  - **Database:** `user_auth` table with a `failed_attempts` column.  
  - **Backend Logic:** Quarkus service tracks and updates failed login attempts.  
  - **Configurable Values:** Login attempt limit and lockout duration.

## Testing/Verification
- **How to Test:**  
  - Attempt multiple failed logins and ensure the account is locked after the threshold is reached.  
  - Attempt to log in after the lockout duration and verify successful authentication.  
- **Logs to Check:**  
  - Logs showing lockout triggers and subsequent unlock events.

## Related Controls
- IA-5: Authenticator Management  
- SI-3: Malicious Code Protection
