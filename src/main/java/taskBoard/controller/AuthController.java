package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import taskBoard.exeption.FailedAuthenticationException;
import taskBoard.model.Employee;
import taskBoard.security.LoginRequest;
import taskBoard.security.LoginResponse;
import taskBoard.security.UserLoginResponse;
import taskBoard.service.EmployeeService;
import taskBoard.service.mapper.EmployeeMapper;

@RestController
@RequestMapping("/task-board/")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.authenticationManager = authenticationManager;
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/login")
    @ApiOperation("Авторизация пользователя")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        logger.debug("Got e - mail: " + loginRequest.getEmail() + " and password: " + loginRequest.getPassword() +
                " and try to authenticate currentUser.");
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
        Employee employee = employeeMapper.toEntity(employeeService.findByEmail(currentUser.getUsername()));
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setEmail(currentUser.getUsername());
//*************************
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResult(true);
        loginResponse.setUserLoginResponse(userLoginResponse);
        return ResponseEntity.ok(loginResponse);
    }
}