package oopstyle;

public class CipherController {

    private Cipher cipher;

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String execute(String message, int key) {
        return this.cipher.execute(message, key);
    }
}
