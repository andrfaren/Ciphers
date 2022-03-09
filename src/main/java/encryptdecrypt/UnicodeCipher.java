package encryptdecrypt;

public class UnicodeCipher implements Cipher {

    CipherMode mode;

    public UnicodeCipher(CipherMode mode) {
        this.mode = mode;
    }

    @Override
    public String execute(String message, int key) {
        switch (mode) {
            case ENCRYPTION:
                return encrypt(message, key);
            case DECRYPTION:
                return decrypt(message, key);
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    @Override
    public String encrypt(String message, int key) {
        // Convert message to a char array
        char[] messageArray = message.toCharArray();

        // Create an array that will store the encrypted chars
        char[] encryptedCharArray = new char[messageArray.length];

        // Move each char in original array by key and populate encrypted array
        for (int i = 0; i < encryptedCharArray.length; i++) {
            if (messageArray[i] + key > 126) {
                encryptedCharArray[i] = (char) ((messageArray[i] + key) % 126 + 31);

            } else {
                encryptedCharArray[i] = (char) (messageArray[i] + key);
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
            if (messageArray[i] - key < 32) {
                decryptedCharArray[i] = (char) (messageArray[i] - key + 95);

            } else {
                decryptedCharArray[i] = (char) (messageArray[i] - key);
            }
        }

        // Convert decrypted array to a string
        String decryptedMessage = String.valueOf(decryptedCharArray);

        // Return the decrypted message
        return decryptedMessage;
    }
}
