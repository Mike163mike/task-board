package taskBoard.exeption;

public class BoardNotFoundException extends AppException {

    public BoardNotFoundException(Long id) {
        super("Board with id: " + id + " not found.");
    }

    public BoardNotFoundException() {
        super("Board not found.");
    }
}
