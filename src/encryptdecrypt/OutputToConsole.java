package encryptdecrypt;

public class OutputToConsole implements OutputMethod {

    @Override
    public void writeMessage(String message, String outputFilePath) {
        System.out.println(message);
    }

}
