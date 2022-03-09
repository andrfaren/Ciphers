package encryptdecrypt;

public class OutputToConsole implements OutputMethod {

    @Override
    public void write(String data) {
        System.out.println(data);
    }

}
