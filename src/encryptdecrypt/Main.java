package encryptdecrypt;

public class Main {

    public static void main(String[] args) {

        String result = "";

        CommandArguments commandArguments = new CommandArguments();

        // Map passed arguments to fields in CommandArguments object
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                commandArguments.setMode(args[i + 1]);
            } else if ("-key".equals(args[i])) {
                commandArguments.setKey(Integer.parseInt(args[i + 1]));
            } else if ("-data".equals(args[i])) {
                commandArguments.setMessage(args[i + 1]);
            } else if ("-in".equals(args[i])) {
                commandArguments.setInputFilePath(args[i + 1]);
            } else if ("-out".equals(args[i])) {
                commandArguments.setOutputFilePath(args[i + 1]);
            } else if ("-alg".equals(args[i])) {
                commandArguments.setAlgorithm(args[i + 1]);
            }
        }

        IOController ioController = new IOController();

        // Read from the specified file path if it exists
        if (!"".equals(commandArguments.getInputFilePath())) {
            ioController.setInputMethod(new InputFromFile());
            commandArguments.setMessage(ioController.read(commandArguments.getInputFilePath()));
        }

        CipherController cipherController = new CipherController();

        if ("unicode".equals(commandArguments.getAlgorithm())) {

            cipherController.setCipher(new UnicodeCipher());

            if ("enc".equals(commandArguments.getMode())) {
                result = cipherController.encrypt(commandArguments.getMessage(), commandArguments.getKey());

            } else if ("dec".equals(commandArguments.getMode())) {
                result = cipherController.decrypt(commandArguments.getMessage(), commandArguments.getKey());
            }

        } else if ("shift".equals(commandArguments.getAlgorithm())) {

            cipherController.setCipher(new ShiftCipher());

            if ("enc".equals(commandArguments.getMode())) {
                result = cipherController.encrypt(commandArguments.getMessage(), commandArguments.getKey());

            } else if ("dec".equals(commandArguments.getMode())) {
                result = cipherController.decrypt(commandArguments.getMessage(), commandArguments.getKey());
            }
        }

        // Output to the specified file path if it exists
        if (!"".equals(commandArguments.getOutputFilePath())) {
            ioController.setOutputMethod(new OutputToFile());
            ioController.write(result, commandArguments.getOutputFilePath());

        // Otherwise, print to the console
        } else {
            System.out.println(result);
        }

    }

}
