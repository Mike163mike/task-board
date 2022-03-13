package taskBoard.exeption;

public class TaskNotFoundException extends AppException {

    public TaskNotFoundException(Integer id) {
        super("Task with id: " + id + " not found.");
    }

    public TaskNotFoundException() {
        super("Tasks not found.");
    }
}
