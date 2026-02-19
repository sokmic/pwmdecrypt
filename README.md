# pwmdecrypt
Decrypts the passwords stored in a PwmConfiguration.xml file downloaded from PWM password self-service application

# Usage
Extract the PWM application war file.  Copy all jar files, the config xml, and this java source file into a folder together.

Run:
```
java -cp "*" pwmdecrypt.java PwmConfiguration.xml
```
Any encrypted "PASSWORD" type values in the file will be decrypted and displayed.
<img width="1510" height="132" alt="image" src="https://github.com/user-attachments/assets/494eea36-9a73-4d4c-aa10-5811a09ffc44" />
