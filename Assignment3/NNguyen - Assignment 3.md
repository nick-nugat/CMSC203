# NNguyen - Assignment 3

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

