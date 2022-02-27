package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.dto.EmployeeDto;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.model.Employee;
import taskBoard.repository.EmployeeRepository;
import taskBoard.service.mapper.EmployeeMapper;

import java.util.*;

@Service
public class EmployeeService {

    static Logger logger = LoggerFactory.getLogger(Employee.class);

    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper employeeMapper) {
        this.repository = repository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        logger.debug("Создаём объект \"Employee\"");

        return employeeMapper.toDto(repository.save(employeeMapper.toEntity(employeeDto)));
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"Employee\" c id = " + id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        repository.delete(employee);
    }

    public Employee findById(Long id) {

        logger.debug("Ищем объект \"Employee\" с id = " + id);

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Set<Employee> findAll() {

        logger.debug("Ищем всех сотрудников");

        return new HashSet<>(repository.findAll());
    }
}
