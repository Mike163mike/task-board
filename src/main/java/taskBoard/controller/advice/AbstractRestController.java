package taskBoard.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import taskBoard.exeption.AppException;

@RestControllerAdvice
public class AbstractRestController {

    @ExceptionHandler({AppException.class})
    public ResponseEntity<String> exceptionHandler(AppException e) {
        return new ResponseEntity<>(e.getMessage() + "*** adviser!!!!", HttpStatus.NOT_FOUND);
    }
}
