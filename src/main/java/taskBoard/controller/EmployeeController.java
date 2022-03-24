package taskBoard.controller;

//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.EmployeeService;
import taskBoard.service.dto.request.EmployeePostRequestDto;
import taskBoard.service.dto.request.EmployeePutRequestDto;
import taskBoard.service.dto.response.EmployeeResponseDto;
import taskBoard.service.mapper.EmployeeMapper;

import java.util.Set;

@RestController
@RequestMapping("/task-board/employee")
//@Tag(description = "Employee API", name = "employee")
public class EmployeeController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService service;
    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    //@ApiOperation("Получение множества всех сотрудников")
    public ResponseEntity<Set<EmployeeResponseDto>> getAll() {
        logger.debug("Получение списка всех сотрудников");
        Set<EmployeeResponseDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/new/{id}")
   // @ApiOperation("Получение сотрудника по id")
    @NonNull
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Integer id) {
        logger.debug("Получение сотрудника по id");
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }

    @PostMapping
   // @ApiOperation("Добавляем нового сотрудника")
    @NonNull
    public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeePostRequestDto employeePostRequestDto) {
        logger.debug("Добавляем нового сотрудника");
        EmployeeResponseDto newEmployeeResponseDto = mapper.map(service.save(mapper.map(employeePostRequestDto)));
        return new ResponseEntity<>(newEmployeeResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   // @ApiOperation("Обновляем данные сотрудника с указанным id")
    @NonNull
    public ResponseEntity<EmployeeResponseDto> update(@RequestBody EmployeePutRequestDto employeePutRequestDto,
                                                      @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные сотрудника с id: " + id);
        return ResponseEntity.ok(mapper.map(service.save(mapper.update(employeePutRequestDto))));
    }

    @DeleteMapping("/{id}")
   // @ApiOperation("Удаляем сотрудника с указанным id")
    @NonNull
    public ResponseEntity<EmployeeResponseDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем сотрудника с указанным id");
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
