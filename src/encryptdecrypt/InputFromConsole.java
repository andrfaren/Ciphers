package encryptdecrypt;
import java.util.Scanner;

public class InputFromConsole implements InputMethod {

    @Override
    public String readMessage(String inputFilePath) {
        Scanner aScanner = new Scanner(System.in);
        return aScanner.nextLine();
    }
}
