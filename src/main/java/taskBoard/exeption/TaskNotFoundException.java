package taskBoard.exeption;

public class TaskNotFoundException extends AppException {

    public TaskNotFoundException(Long id) {
        super("Task with id: " + id + " not found.");
    }

    public TaskNotFoundException() {
        super("Tasks not found.");
    }
}
