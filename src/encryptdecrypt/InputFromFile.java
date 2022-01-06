package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFromFile implements InputMethod {

    @Override
    public String readMessage(String inputFilePath) {
        String message = "";

        File inputFile = new File(inputFilePath);

        try (Scanner scanner = new Scanner(inputFile)) {
            message = scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.printf("File %s not found.\n");
        }

        return message;
    }
}
