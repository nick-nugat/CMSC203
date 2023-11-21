# NNguyen - Assignment 3
## Screenshots
### JUnit Tests
![[Attachments/Pasted image 20231014232607.png]]
### GitHub
![[Attachments/Pasted image 20231014232405.png]]

## Test Plan
### Caesar Encryption and Decryption #1
> [!check] Passed!
> ![[Attachments/Pasted image 20231014233101.png|500]]

### Caesar Encryption and Decryption #2
> [!check] Passed!
> ![[Attachments/Pasted image 20231014233137.png|500]]

### Bellaso Encryption and Decryption #1
> [!check] Passed!
> ![[Attachments/Pasted image 20231014233441.png|500]]

### Bellaso Encryption and Decryption #2
> [!check] Passed!
> ![[Attachments/Pasted image 20231014233509.png|500]]


## Pseudocode
```
Function isStringInBounds(plainText)
    For each character c in plainText
        If c is not within the allowable bounds
            Return false
    End For
    Return true


Function caesarEncryption(plainText, key)
    If not isStringInBounds(plainText)
        Return "The selected string is not in bounds, Try again."
    
    Adjust key within the allowable range
    
    Create an empty character array encrypted
    
    For each character c in plainText
        Encrypt c using the Caesar Cipher with the given key
        Append the encrypted character to the encrypted array
    End For
    
    Return a string created from the encrypted character array


Function caesarDecryption(encryptedText, key)
    If not isStringInBounds(encryptedText)
        Return "The selected string is not in bounds, Try again."
    
    Adjust key within the allowable range
    
    Create an empty character array decrypted
    
    For each character c in encryptedText
        Decrypt c using the inverse of the Caesar Cipher with the given key
        Append the decrypted character to the decrypted array
    End For
    
    Return a string created from the decrypted character array


Function bellasoEncryption(plainText, bellasoStr)
    Create an empty character array encrypted
    
    For i = 0 to length of plainText
        Encrypt the character at index i in plainText using Bellaso Cipher with bellasoStr
        Append the encrypted character to the encrypted array
    End For
    
    Return a string created from the encrypted character array


Function bellasoDecryption(encryptedText, bellasoStr)
    Create an empty character array decrypted
    
    For i = 0 to length of encryptedText
        Decrypt the character at index i in encryptedText using the inverse of Bellaso Cipher with bellasoStr
        Append the decrypted character to the decrypted array
    End For
    
    Return a string created from the decrypted character array
```

## Questions to Answer
> [!question] Write about your Learning Experience, highlighting your lessons learned and learning experience from working on this project.
> I had a pretty fun time doing this project. I had fun learning more about encryption methods and how to implement them in Java.


> [!question] What have you learned?
> I learned how to implement encryption methods in Java, as well as how helpful JUnit test cases can be in helping the programmer make sure the code they write works as intended.


> [!question] What did you struggle with?
> I struggled with implementing the decryption methods for both Caesar's and Bellaso's encryption methods. Although I thought it would be as easy as reversing the steps done in the encryption methods, it ended up being a lot more than that and being super time consuming to figure out.


> [!question] What would you do differently on your next project?
> I would likely plan out my time better and take more breaks to prevent frustration and burnout.


> [!question] What parts of this assignment were you successful with, and what parts (if any) were you not successful with?
> I was successful with the majority of it; I understood everything I did and I am happy with the result.


> [!question] Provide any additional resources/links/videos you used to while working on this assignment/project.
> N/A

