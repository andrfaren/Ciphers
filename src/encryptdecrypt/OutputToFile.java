package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile implements OutputMethod {

    @Override
    public void writeMessage(String message, String outputFilePath) {

        File outputFile = new File(outputFilePath);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(message);

        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }

    }
}
