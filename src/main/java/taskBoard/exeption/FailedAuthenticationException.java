package taskBoard.exeption;

public class FailedAuthenticationException extends AppException{

    public FailedAuthenticationException(String message) {
        super("Authentication failed");
    }

    public FailedAuthenticationException() {
        super("Authentication failed");
    }
}
