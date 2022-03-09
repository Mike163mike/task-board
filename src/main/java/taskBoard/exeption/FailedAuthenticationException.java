package taskBoard.exeption;

public class FailedAuthenticationException extends AppException {

    public FailedAuthenticationException() {
        super("Authentication was failed");
    }
}
