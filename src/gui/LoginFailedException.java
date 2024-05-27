package gui;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("Login failed. Invalid username or password.");
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }
}
