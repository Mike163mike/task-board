package taskBoard.security;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.model.Employee;
import taskBoard.service.EmployeeService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    private final EmployeeService employeeService;

    @Autowired
    public UserDetailsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        logger.debug("Ищем сотрудника по e - mail");
        Set<Employee> employees = employeeService.findAll();
        Employee result = employees.stream()
                .filter(employee -> employee.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new EmployeeNotFoundException());
        return SecurityUser.fromEmployee(result);
    }
}

