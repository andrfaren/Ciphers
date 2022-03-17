package oopstyle;

public interface Cipher {
    String execute(String message, int key);
    String encrypt(String message, int key);
    String decrypt(String message, int key);
}
