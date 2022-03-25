package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.model.Employee;
import taskBoard.repository.EmployeeRepository;
import taskBoard.service.mapper.EmployeeMapper;

import java.util.*;

@Service
public class EmployeeService {

    static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper employeeMapper) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        logger.debug("Создаём объект \"Employee\"");
        return repository.save(employee);
    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Employee\" c id = " + id);
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        repository.delete(employee);
    }

    public Employee findById(Integer id) {
        logger.debug("Ищем объект \"Employee\" с id = " + id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Set<Employee> findAll() {
        logger.debug("Ищем всех сотрудников");
        return new HashSet<>(repository.findAll());
    }

    public Employee findByEmail(String email) {
        Set<Employee> employees = findAll();
        for (Employee employee:employees) {
            if (employee.getEmail().equals(email)) {
                return employee;
            }
        }
        return null;
    }
}
