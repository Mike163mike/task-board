package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Board;
import taskBoard.model.Employee;
import taskBoard.repository.EmployeeRepository;

@Service
public class EmployeeService {

    static Logger logger = LoggerFactory.getLogger(Employee.class);

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {

        logger.debug("Создаём объект \"Employee\" c id = " + employee.getId());

        return repository.save(employee);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"Employee\" c id = " + id);

        repository.deleteById(id);
    }

    public Employee findById(long id) {

        logger.debug("Ищем объект \"Employee\" с id = " + id);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id = " + id + " was not found"));
    }
}
