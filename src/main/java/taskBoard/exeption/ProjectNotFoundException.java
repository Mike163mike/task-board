package taskBoard.exeption;

public class ProjectNotFoundException extends AppException {

    public ProjectNotFoundException(Long id) {
        super("Project with id: " + id + " not found.");
    }

    public ProjectNotFoundException() {
        super("Projects not found.");
    }
}
