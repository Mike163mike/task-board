package taskBoard.exeption;

//@Component
public class EmployeeNotFoundException extends AppException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with id: " + id + " not found.");
    }

    public EmployeeNotFoundException() {
        super("Employees not found.");
    }
}
