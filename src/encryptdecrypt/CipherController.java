package encryptdecrypt;

public class CipherController {
    private Cipher cipher;


    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String encrypt(String message, int key) {
        return this.cipher.encrypt(message, key);
    }

    public String decrypt(String message, int key) {
        return this.cipher.decrypt(message, key);
    }

}
