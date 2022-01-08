package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile implements OutputMethod {

    private String filePath;

    public OutputToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String data) {

        File outputFile = new File(filePath);

        // Print location of output file
        System.out.println(outputFile.getAbsolutePath());

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(data);

        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }

    }
}
