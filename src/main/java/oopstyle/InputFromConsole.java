package oopstyle;

public class InputFromConsole implements InputMethod {

    private String argData;

    public InputFromConsole(String argData) {
        this.argData = argData;
    }

    @Override
    public String load() {
        return argData;
    }
}
