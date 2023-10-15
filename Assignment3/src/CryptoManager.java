
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			if (c < LOWER_RANGE || c > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) return "The selected string is not in bounds, Try again.";
		while (key > UPPER_RANGE) key -= RANGE;

		char[] plain = plainText.toCharArray(),
			   encrypted = new char[plain.length];

		for (int i = 0; i < plainText.length(); i++){
			char value = plain[i];
			value += key;
			while (value > UPPER_RANGE) value -= RANGE;
			encrypted[i] = value;
		}
		return new String(encrypted);
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) return "The selected string is not in bounds, Try again.";
		while (key > UPPER_RANGE) key -= RANGE;

		char[] encrypted = encryptedText.toCharArray();
		char[] decrypted = new char[encrypted.length];

		for (int i = 0; i < encryptedText.length(); i++){
			char value = encrypted[i];
			value -= key;
			while (value < LOWER_RANGE) value += RANGE;
			decrypted[i] = value;
		}
		return new String(decrypted);
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
        char[] plain = plainText.toCharArray();
        char[] encrypted = new char[plain.length];

        for (int i = 0; i < plain.length; i++) {
            char plainChar = plain[i];
            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
			int totalOfChar = plainChar + bellasoChar;
            int encryptedCharValue = ((totalOfChar - LOWER_RANGE) % RANGE) + LOWER_RANGE;

            encrypted[i] = (char) encryptedCharValue;
        }

        return new String(encrypted);
    }
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        char[] encrypted = encryptedText.toCharArray();
        char[] decrypted = new char[encrypted.length];
     
        for (int i = 0; i < encrypted.length; i++) {
            char encryptedChar = encrypted[i];
            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
            // Calculate the decrypted character value (taking wrapping into account)
            int decryptedCharValue = encryptedChar - bellasoChar;

            // Reverse modulo
            while (decryptedCharValue < LOWER_RANGE) decryptedCharValue += RANGE;

            while (decryptedCharValue > UPPER_RANGE) decryptedCharValue -= RANGE;

            decrypted[i] = (char) decryptedCharValue;
        }
     
        return new String(decrypted);
     }
	 
	 
	 
	 
}


