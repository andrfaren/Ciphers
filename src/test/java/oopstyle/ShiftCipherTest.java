package oopstyle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftCipherTest {

    @Test
    void execute() {
        ShiftCipher shiftCipherEncryption = new ShiftCipher(CipherMode.ENCRYPTION);
        ShiftCipher shiftCipherDecryption = new ShiftCipher(CipherMode.DECRYPTION);

        // Check that encryption/decryption works for obvious cases
        assertEquals("Cpftgy", shiftCipherEncryption.execute("Andrew", 2));
        assertEquals("Andrew", shiftCipherDecryption.execute("Cpftgy", 2));

        // Check if wrong cipher mode is used
        assertNotEquals("Cpftgy", shiftCipherDecryption.execute("Andrew", 2));
        assertNotEquals("Andrew", shiftCipherEncryption.execute("Cpftgy", 2));


    }
}