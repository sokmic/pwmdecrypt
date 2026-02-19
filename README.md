# pwmdecrypt
Decrypts the passwords stored in a PwmConfiguration.xml file downloaded from PWM password self-service application

# Usage
Extract the PWM application war file.  Copy all jar files, the config xml, and this java source file into a folder together.

Run:
```
java -cp "*" pwmdecrypt.java PwmConfiguration.xml
```
Any encrypted "PASSWORD" type values in the file will be decrypted and displayed.
<img width="1508" height="131" alt="image" src="https://github.com/user-attachments/assets/f4a76f6c-3b35-4573-b0a3-e87bc9528b27" />

