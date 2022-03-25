package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskBoard.security.LoginRequest;
import taskBoard.security.LoginResponse;
import taskBoard.service.SecurityService;

@RestController
@RequestMapping("/task-board/")
public class AuthController {

    private final SecurityService service;

    static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(SecurityService service) {
        this.service = service;
    }

    @PostMapping("/login")
    @ApiOperation("Авторизация пользователя")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        logger.debug("Got e - mail: " + loginRequest.getEmail() + " and password: " + loginRequest.getPassword() +
                " and try to authenticate currentUser.");
        LoginResponse loginResponse = service.getLoginResponse(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
