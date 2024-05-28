package Exceptions;

public class CustomerNotFoundException extends Throwable {
    public CustomerNotFoundException(String s) {
        super(s);
    }
}
