package dew;

public class DewException extends Exception {
    public DewException(String message) {
        super("____________________________________________________________\n"
                + message + "\n"
        + "_________________________________________________________________\n");
    }
}
