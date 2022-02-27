package taskBoard.exeption;

import org.springframework.stereotype.Component;

//@Component
public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}
