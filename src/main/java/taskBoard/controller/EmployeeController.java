package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskBoard.dto.EmployeeDto;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("task-board/employee")
public class EmployeeController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation("Получение списка всех сотрудников")
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
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id) {

        logger.debug("Получение сотрудника по id");

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployeeDto employeeDto = employeeService.findById(id);

        if (employeeDto == null) {
            throw new EmployeeNotFoundException(id);
        }

        return ResponseEntity.ok(employeeDto);
    }


    @PostMapping
    @ApiOperation("Добавляем нового сотрудника")
    public ResponseEntity<EmployeeDto> create(@ModelAttribute("employeeDto") EmployeeDto employeeDto) {

        logger.debug("Добавляем нового сотрудника");

        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(newEmployeeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные сотрудника с указанным id")
    public ResponseEntity<EmployeeDto> update(@ModelAttribute("employee") EmployeeDto employeeDto,
                                              @PathVariable("id") Long id) {

        logger.debug("Обновляем данные сотрудника с id: " + id);

        if (id == null || employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);

        return ResponseEntity.ok(newEmployeeDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем сотрудника с указанным id")
    public ResponseEntity<EmployeeDto> deleteById(@PathVariable("id") Long id) {

        logger.debug("Удаляем сотрудника с указанным id");

        EmployeeDto employeeDto = employeeService.findById(id);
        if (employeeDto == null) {
            throw new EmployeeNotFoundException(id);
        }

        employeeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
