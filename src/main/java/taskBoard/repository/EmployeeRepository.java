package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskBoard.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
