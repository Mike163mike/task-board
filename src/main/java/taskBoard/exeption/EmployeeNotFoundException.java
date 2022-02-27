package taskBoard.exeption;

import org.springframework.stereotype.Component;

//@Component
public class EmployeeNotFoundException extends AppException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with id: " + id + " not found.");
    }
}
