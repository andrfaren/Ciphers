package encryptdecrypt;

public class CommandArguments {
    private String message = "";
    private String outputFilePath = null;
    private String inputFilePath = null;
    private String cipher = "shift";
    private String mode = "enc";
    private String outputMethod = "console";
    private String inputMethod = "console";
    private int key = 0;

    public CommandArguments(String[] args) {
        extractArgs(args);
    }

    private void extractArgs(String[] args) {

        // Map passed arguments to fields in CommandArguments object
        for (int i = 0; i < args.length; i++) {

            if ("-mode".equals(args[i])) {
                mode = (args[i + 1]);

            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);

            } else if ("-data".equals(args[i])) {
                message = args[i + 1];

            } else if ("-in".equals(args[i])) {
                inputFilePath = args[i + 1];
                inputMethod = "file";

            } else if ("-out".equals(args[i])) {
                outputFilePath = args[i + 1];
                outputMethod = "file";

            } else if ("-alg".equals(args[i])) {
                cipher = args[i + 1];
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public String getOutputMethod() {
        return outputMethod;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getInputMethod() {
        return inputMethod;
    }

    public String getCipher() {
        return cipher;
    }

    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

}
