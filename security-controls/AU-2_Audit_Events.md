# AU-2: Audit Events

## Objective
**Purpose:** Capture and log critical system events for accountability and troubleshooting.

## Implementation Details
- **Description:**  
  The system logs important user actions (such as login, failed login attempts, and data access) to an audit log. Logs include timestamps, user information, and action details.  
- **Technology:**  
  - **Logging Framework:** Quarkus with built-in logging capabilities (`Logger`).  
  - **Database:** Audit logs stored in a dedicated table (if needed).

## Testing/Verification
- **How to Test:**  
  - Verify that login, logout, and failed login attempts are recorded.  
  - Confirm that unauthorized access attempts are logged with the relevant user information.  
- **Logs to Check:**  
  - Check the logs for events such as login success, failed login attempts, and role-based access denials.

## Related Controls
- AC-2: Account Management  
- AC-6: Least Privilege
