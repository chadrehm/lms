# SC-28: Protection of Information at Rest

## Objective
**Purpose:** Ensure that sensitive data stored in the database is protected from unauthorized access by encryption.

## Implementation Details
- **Description:**  
  Sensitive data stored in the PostgreSQL database (such as user credentials and personal information) is encrypted to ensure confidentiality and prevent unauthorized access in the event of a data breach.  
- **Technology:**  
  - **Encryption:** Transparent Data Encryption (TDE) or equivalent is implemented for encrypting sensitive data at rest.  
  - **Database:** PostgreSQL encryption extensions or third-party tools may be used to implement encryption for the `user_auth` and `user_profile` tables.

## Testing/Verification
- **How to Test:**  
  - Verify that encrypted data is unreadable without the appropriate keys by attempting to access encrypted columns or backup files without decryption access.  
  - Test that data at rest is protected even in the event of unauthorized database access.
- **Logs to Check:**  
  - Database logs for any errors related to encryption or unauthorized access attempts.

## Related Controls
- SC-7: Boundary Protection  
- SC-12: Cryptographic Key Establishment and Management
