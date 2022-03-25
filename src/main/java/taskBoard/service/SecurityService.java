package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import taskBoard.exeption.FailedAuthenticationException;
import taskBoard.model.Employee;
import taskBoard.security.LoginRequest;
import taskBoard.security.LoginResponse;
import taskBoard.security.UserLoginResponse;

@Service
public class SecurityService {

    static Logger logger = LoggerFactory.getLogger(SecurityService.class);

    private final AuthenticationManager authenticationManager;
    private final EmployeeService employeeService;

    public SecurityService(AuthenticationManager authenticationManager, EmployeeService employeeService) {
        this.authenticationManager = authenticationManager;
        this.employeeService = employeeService;
    }

    public LoginResponse getLoginResponse(LoginRequest loginRequest) {
        logger.debug("Try to authenticate user with email: " + loginRequest.getEmail());
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new FailedAuthenticationException();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User currentUser = (User) authentication.getPrincipal();
        Employee employee = employeeService.findByEmail(currentUser.getUsername());
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setEmail(currentUser.getUsername());
        userLoginResponse.setId(employee.getId());
        userLoginResponse.setName(employee.getSurname() + employee.getName());
        userLoginResponse.setRole(employee.getRole());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResult(true);
        loginResponse.setUserLoginResponse(userLoginResponse);
        return loginResponse;
    }
}
