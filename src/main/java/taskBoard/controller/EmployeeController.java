package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskBoard.dto.EmployeeDto;
import taskBoard.model.Employee;
import taskBoard.service.EmployeeService;
import taskBoard.service.mapper.EmployeeMapper;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    @ApiOperation("Получение списка всех сотрудников")
    public ResponseEntity<Set<EmployeeDto>> getAll() {

        logger.debug("Получение списка всех сотрудников");

        Set<Employee> employees = employeeService.findAll();

        Set<EmployeeDto> employeeDtos = employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toSet());

        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);

    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение сотрудника по id")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id) {

        logger.debug("Получение сотрудника по id");

        if (id == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employee employee = employeeService.findById(id);

        if (employee == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeMapper.toDto(employee), HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation("Добавляем нового сотрудника")
    public ResponseEntity<EmployeeDto> create(@ModelAttribute("employeeDto") EmployeeDto employeeDto) {

        logger.debug("Добавляем нового сотрудника");

        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(newEmployeeDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}/edit")
    @ApiOperation("Обновляем данные сотрудника с указанным id")
    public ResponseEntity<EmployeeDto> update(@ModelAttribute("employee") EmployeeDto employeeDto,
                                              @PathVariable("id") Long id) {

        logger.debug("Обновляем данные сотрудника с id: " + id);

        if (id == null || employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(newEmployeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем сотрудника с указанным id")
    public ResponseEntity<EmployeeDto> deleteById(@PathVariable("id") Long id) {

        logger.debug("Удаляем сотрудника с указанным id");

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        employeeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
