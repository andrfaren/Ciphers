package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFromFile implements InputMethod {

    private String filePath;

    public InputFromFile(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public String load() {

        StringBuilder fileContent = new StringBuilder();

        File inputFile = new File(filePath);

        // Print location of input file
        System.out.println(inputFile.getAbsolutePath());

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File %s not found.\n", filePath);
        }

        return fileContent.toString();
    }
}
