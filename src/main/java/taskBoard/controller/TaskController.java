package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskBoard.dto.TaskDto;
import taskBoard.exeption.TaskNotFoundException;
import taskBoard.service.TaskService;

import java.util.Set;

@RestController
@RequestMapping("task-board/task")
public class TaskController {

    static Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @ApiOperation("Получение списка всех задач")
    public ResponseEntity<Set<TaskDto>> getAll() {

        logger.debug("Получение списка всех задач");

        Set<TaskDto> taskDtos = taskService.findAll();

        if (taskDtos.isEmpty()) {
            throw new TaskNotFoundException();
        }

        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение задачи по id")
    public ResponseEntity<TaskDto> getById(@PathVariable Long id) {

        logger.debug("Получение задачи по id");

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TaskDto taskDto = taskService.findById(id);

        if (taskDto == null) {
            throw new TaskNotFoundException(id);
        }

        return ResponseEntity.ok(taskDto);
    }


    @PostMapping
    @ApiOperation("Добавляем новую задачу")
    public ResponseEntity<TaskDto> create(@ModelAttribute("task") TaskDto taskDto) {

        logger.debug("Добавляем новую задачу");

        if (taskDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TaskDto newTaskDto = taskService.createTask(taskDto);

        return new ResponseEntity<>(newTaskDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные задачи с указанным id")
    public ResponseEntity<TaskDto> update(@ModelAttribute("task") TaskDto taskDto,
                                          @PathVariable("id") Long id) {

        logger.debug("Обновляем данные задачи с id: " + id);

        if (id == null || taskDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TaskDto newTaskDto = taskService.createTask(taskDto);

        return ResponseEntity.ok(newTaskDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем задачу с указанным id")
    public ResponseEntity<TaskDto> deleteById(@PathVariable("id") Long id) {

        logger.debug("Удаляем задачу с указанным id");

        TaskDto taskDto = taskService.findById(id);
        if (taskDto == null) {
            throw new TaskNotFoundException(id);
        }

        taskService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

