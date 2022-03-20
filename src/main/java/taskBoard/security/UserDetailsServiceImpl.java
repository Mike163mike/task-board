package taskBoard.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import taskBoard.service.EmployeeService;
import taskBoard.service.dto.EmployeeDto;
import taskBoard.service.mapper.EmployeeMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public UserDetailsServiceImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        logger.debug("Ищем сотрудника по e - mail");
        EmployeeDto employeeDto = employeeService.findByEmail(email);
        return SecurityUser.fromEmployee(employeeDto);
    }
}

