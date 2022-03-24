package taskBoard.controller;

//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.dto.request.TaskPostRequestDto;
import taskBoard.service.dto.request.TaskPutRequestDto;
import taskBoard.service.dto.response.TaskResponseDto;
import taskBoard.service.TaskService;
import taskBoard.service.mapper.TaskMapper;

import java.util.Set;

@RestController
@RequestMapping("/task-board/task")
//@Tag(description = "Task API", name = "task")
public class TaskController {

    static Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskService service;
    private final TaskMapper mapper;

    public TaskController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    //@ApiOperation("Получение множества всех задач")
    public ResponseEntity<Set<TaskResponseDto>> getAll() {
        logger.debug("Получение списка всех задач");
        Set<TaskResponseDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/new/{id}")
    //@ApiOperation("Получение задачи по id")
    @NonNull
    public ResponseEntity<TaskResponseDto> getById(@PathVariable Integer id) {
        logger.debug("Получение задачи по id");
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }


    @PostMapping
    //@ApiOperation("Добавляем новую задачу")
    @NonNull
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskPostRequestDto taskPostRequestDto) {
        logger.debug("Добавляем новую задачу");
        TaskResponseDto newTaskResponseDto = mapper.map(service.save(mapper.map(taskPostRequestDto)));
        return new ResponseEntity<>(newTaskResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   // @ApiOperation("Обновляем данные задачи с указанным id")
    @NonNull
    public ResponseEntity<TaskResponseDto> update(@RequestBody TaskPutRequestDto taskPutRequestDto,
                                                  @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные задачи с id: " + id);
        return ResponseEntity.ok(mapper.map(service.save(mapper.update(taskPutRequestDto))));
    }

    @DeleteMapping("/{id}")
   // @ApiOperation("Удаляем задачу с указанным id")
    @NonNull
    public ResponseEntity<TaskResponseDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем задачу с указанным id");
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

