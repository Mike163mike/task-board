package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.service.EmployeeService;
import taskBoard.service.dto.EmployeeDto;

import java.util.Set;

@RestController
@RequestMapping("/task-board/employee")
public class EmployeeController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation("Получение множества всех сотрудников")
    public ResponseEntity<Set<EmployeeDto>> getAll() {
        logger.debug("Получение списка всех сотрудников");
        Set<EmployeeDto> employeeDtos = employeeService.findAll();
        if (employeeDtos.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение сотрудника по id")
    @NonNull
    public ResponseEntity<EmployeeDto> getById(@PathVariable Integer id) {
        logger.debug("Получение сотрудника по id");
        EmployeeDto employeeDto = employeeService.findById(id);
        if (employeeDto == null) {
            throw new EmployeeNotFoundException(id);
        }
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping
    @ApiOperation("Добавляем нового сотрудника")
    @NonNull
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        logger.debug("Добавляем нового сотрудника");
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(newEmployeeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные сотрудника с указанным id")
    @NonNull
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto,
                                              @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные сотрудника с id: " + id);
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(newEmployeeDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем сотрудника с указанным id")
    @NonNull
    public ResponseEntity<EmployeeDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем сотрудника с указанным id");
        EmployeeDto employeeDto = employeeService.findById(id);
        if (employeeDto == null) {
            throw new EmployeeNotFoundException(id);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
