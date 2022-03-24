package taskBoard.controller;

//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.dto.request.ProjectPutRequestDto;
import taskBoard.service.dto.response.ProjectPostRequestDto;
import taskBoard.service.ProjectService;
import taskBoard.service.mapper.ProjectMapper;

import java.util.Set;

@RestController
@RequestMapping("/task-board/project")
//@Tag(description = "Project API", name = "project")
public class ProjectController {

    static Logger logger = LoggerFactory.getLogger(taskBoard.controller.EmployeeController.class);
    private final ProjectService service;
    private final ProjectMapper mapper;

    public ProjectController(ProjectService service, ProjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    //@ApiOperation("Получение множества всех проектов")
    public ResponseEntity<Set<ProjectPostRequestDto>> getAll() {
        logger.debug("Получение списка всех проектов");
        Set<ProjectPostRequestDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/new/{id}")
  //  @ApiOperation("Получение проекта по id")
    @NonNull
    public ResponseEntity<ProjectPostRequestDto> getById(@PathVariable Integer id) {
        logger.debug("Получение проекта по id");
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }

    @PostMapping
   // @ApiOperation("Добавляем новый  проект")
    @NonNull
    public ResponseEntity<ProjectPostRequestDto> create(@RequestBody taskBoard.service.dto.request.ProjectPostRequestDto projectPostRequestDto) {
        logger.debug("Добавляем новый проект");
        ProjectPostRequestDto newProjectPostRequestDto = mapper.map(service.save(mapper.map(projectPostRequestDto)));
        return new ResponseEntity<>(newProjectPostRequestDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   // @ApiOperation("Обновляем данные проекта с указанным id")
    @NonNull
    public ResponseEntity<ProjectPostRequestDto> update(@RequestBody ProjectPutRequestDto projectPutRequestDto,
                                                        @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные роекта с id: " + id);
        return ResponseEntity.ok(mapper.map(service.save(mapper.update(projectPutRequestDto))));
    }

    @DeleteMapping("/{id}")
   // @ApiOperation("Удаляем проект с указанным id")
    @NonNull
    public ResponseEntity<ProjectPostRequestDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем проект с указанным id");
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
