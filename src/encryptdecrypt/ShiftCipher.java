package encryptdecrypt;

public class ShiftCipher implements Cipher {

    // Strings that represent the alphabet in lower and uppercase
    final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt(String message, int key) {

        // Convert message to a char array
        char[] messageArray = message.toCharArray();

        // Create an array that will store the encrypted chars
        char[] encryptedCharArray = new char[messageArray.length];

        // Move each char in either lower or uppercase alphabet array by key and populate encrypted array
        for (int i = 0; i < encryptedCharArray.length; i++) {

            int indexOfShiftedUpperCaseCharacter = UPPER_CASE_ALPHABET.indexOf(messageArray[i]) + key;
            int indexOfShiftedLowerCaseCharacter = LOWER_CASE_ALPHABET.indexOf(messageArray[i]) + key;

            if (Character.isLowerCase(messageArray[i])) {
                if (indexOfShiftedLowerCaseCharacter > 25) {
                    encryptedCharArray[i] = LOWER_CASE_ALPHABET.charAt(indexOfShiftedLowerCaseCharacter % 26);
                } else {
                    encryptedCharArray[i] = LOWER_CASE_ALPHABET.charAt(indexOfShiftedLowerCaseCharacter);
                }

            } else if (Character.isUpperCase(messageArray[i])) {
                if (indexOfShiftedUpperCaseCharacter > 25) {
                    encryptedCharArray[i] = UPPER_CASE_ALPHABET.charAt((indexOfShiftedUpperCaseCharacter) % 26);
                } else {
                    encryptedCharArray[i] = UPPER_CASE_ALPHABET.charAt(indexOfShiftedUpperCaseCharacter);
                }

            } else {
                encryptedCharArray[i] = messageArray[i];
            }
        }

        // Convert encrypted array to a string
        String encryptedMessage = String.valueOf(encryptedCharArray);

        // Return the encrypted message
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message, int key) {
        // Convert message to a char array
        char[] messageArray = message.toCharArray();

        // Create an array that will store the decrypted chars
        char[] decryptedCharArray = new char[messageArray.length];

        // Move each char in original array by key and populate decrypted array
        for (int i = 0; i < decryptedCharArray.length; i++) {

            int indexOfShiftedUpperCaseCharacter = UPPER_CASE_ALPHABET.indexOf(messageArray[i]) - key;
            int indexOfShiftedLowerCaseCharacter = LOWER_CASE_ALPHABET.indexOf(messageArray[i]) - key;

            if (Character.isLowerCase(messageArray[i])) {
                if (indexOfShiftedLowerCaseCharacter < 0) {
                    decryptedCharArray[i] = LOWER_CASE_ALPHABET.charAt((indexOfShiftedLowerCaseCharacter) + 26);
                } else {
                    decryptedCharArray[i] = LOWER_CASE_ALPHABET.charAt(indexOfShiftedLowerCaseCharacter);
                }

            } else if (Character.isUpperCase(messageArray[i])) {
                if (indexOfShiftedUpperCaseCharacter < 0) {
                    decryptedCharArray[i] = UPPER_CASE_ALPHABET.charAt((indexOfShiftedUpperCaseCharacter) + 26);
                } else {
                    decryptedCharArray[i] = UPPER_CASE_ALPHABET.charAt(indexOfShiftedUpperCaseCharacter);
                }
            } else {
                decryptedCharArray[i] = messageArray[i];
            }
        }

        // Convert decrypted array to a string
        String decryptedMessage = String.valueOf(decryptedCharArray);

        // Return the decrypted message
        return decryptedMessage;
    }

}
