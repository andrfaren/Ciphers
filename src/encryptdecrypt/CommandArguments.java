package encryptdecrypt;

public class CommandArguments {
    private String message;
    private String outputFilePath;
    private String inputFilePath;
    private String algorithm;
    private String mode;
    private int key;

    public CommandArguments() {
        this.message = "";
        this.outputFilePath = "";
        this.inputFilePath = "";
        this.algorithm = "shift";
        this.mode = "enc";
        this.key = 0;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
