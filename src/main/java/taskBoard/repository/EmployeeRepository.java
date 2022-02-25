package taskBoard.repository;

import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
