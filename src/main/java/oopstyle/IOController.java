package oopstyle;

public class IOController {

    private InputMethod inputMethod;
    private OutputMethod outputMethod;

    public void setInputMethod(InputMethod inputMethod) {
        this.inputMethod = inputMethod;
    }

    public void setOutputMethod(OutputMethod outputMethod) {
        this.outputMethod = outputMethod;
    }

    public String getInputData() {
        return inputMethod.load();
    }

    public void write(String data) {
        this.outputMethod.write(data);
    }
}
