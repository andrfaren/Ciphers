package encryptdecrypt;

public class IOController {
    private InputMethod inputMethod;
    private OutputMethod outputMethod;

    public void setInputMethod(InputMethod inputMethod) {
        this.inputMethod = inputMethod;
    }

    public void setOutputMethod(OutputMethod outputMethod) {
        this.outputMethod = outputMethod;
    }

    public String read(String inputFilePath) {
        return this.inputMethod.readMessage(inputFilePath);
    }

    public void write(String message, String outputFilePath) {
        this.outputMethod.writeMessage(message, outputFilePath);
    }
}
