# SC-13: Cryptographic Protection

## Objective
**Purpose:** Ensure the confidentiality and integrity of data in transit by using cryptographic protections.

## Implementation Details
- **Description:**  
  All communication between the React frontend and the Quarkus backend is encrypted using HTTPS to prevent interception and tampering of sensitive data.  
- **Technology:**  
  - **Encryption Protocol:** TLS (Transport Layer Security) is used to encrypt HTTP traffic (HTTPS).  
  - **Certificates:** A valid SSL/TLS certificate is installed and configured on the Quarkus backend.

## Testing/Verification
- **How to Test:**  
  - Verify that communication between the frontend and backend is only possible via HTTPS by checking for successful TLS negotiation in browser dev tools or network traffic analysis.  
  - Ensure that any unencrypted HTTP requests are blocked or redirected to HTTPS.
- **Logs to Check:**  
  - Web server logs for SSL/TLS connection success or failure.

## Related Controls
- SC-7: Boundary Protection  
- AC-17: Remote Access
