public class EncryptionPractice {
    private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    
    public static String bellasoEncryption(String plainText, String bellasoStr) {
		int difference = plainText.length() - bellasoStr.length(), total;
		if (difference >= 0) bellasoStr += bellasoStr.substring(0, difference);

		char[] plain = plainText.toCharArray(),
			   offset = bellasoStr.toCharArray(),
			   encrypted = new char[plain.length];

		for(int i = 0; i < plain.length; i++){
			total = plain[i] + offset[i];
			while (total > UPPER_RANGE) total -= RANGE;
			encrypted[i] = (char)total;
		}
		return new String(encrypted);
	}
}
