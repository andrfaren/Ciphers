package oopstyle;

public class EncryptionDecryption {
    private CommandArguments commandArguments;
    private IOController ioController;
    private CipherController cipherController;
    private String data;

    public EncryptionDecryption(CommandArguments commandArguments) {
        this.commandArguments = commandArguments;
    }

    public void execute() {
        selectIO();
        selectCipher();
        executeCipher();
        outputData();
    }

    private void selectIO() {

        ioController = new IOController();

        if (commandArguments.getOutputMethod().equals("file")) {
            ioController.setOutputMethod(new OutputToFile(commandArguments.getOutputFilePath()));

        } else if (commandArguments.getOutputMethod().equals("console")) {
            ioController.setOutputMethod(new OutputToConsole());

        } if (commandArguments.getInputMethod().equals("file")) {
            ioController.setInputMethod(new InputFromFile(commandArguments.getInputFilePath()));

        } else if (commandArguments.getInputMethod().equals("console")) {
            ioController.setInputMethod(new InputFromConsole(commandArguments.getMessage()));
        }
    }

    private void outputData() {
        ioController.write(data);
    }

    private void executeCipher() {
        data = cipherController.execute(ioController.getInputData(), commandArguments.getKey());
    }

    private void selectCipher() {

        cipherController = new CipherController();

        switch (commandArguments.getMode()) {
            case "enc":
                switch (commandArguments.getCipher()) {
                    case "shift":
                        cipherController.setCipher(new ShiftCipher(CipherMode.ENCRYPTION));
                        break;
                    case "unicode":
                        cipherController.setCipher(new UnicodeCipher(CipherMode.ENCRYPTION));
                        break;
                }

                break;
            case "dec":
                switch (commandArguments.getCipher()) {
                    case "shift":
                        cipherController.setCipher(new ShiftCipher(CipherMode.DECRYPTION));
                        break;
                    case "unicode":
                        cipherController.setCipher(new UnicodeCipher(CipherMode.DECRYPTION));
                        break;
                }
                break;
            default:
                System.out.println("Incorrect type");
        }
    }
}
