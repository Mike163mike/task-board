package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.dto.ProjectDto;
import taskBoard.exeption.ProjectNotFoundException;
import taskBoard.service.ProjectService;

import java.util.Set;

@RestController
@RequestMapping("/task-board/project")
public class ProjectController {

    static Logger logger = LoggerFactory.getLogger(taskBoard.controller.EmployeeController.class);
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @ApiOperation("Получение множества всех проектов")
    public ResponseEntity<Set<ProjectDto>> getAll() {
        logger.debug("Получение списка всех проектов");
        Set<ProjectDto> projectDtos = projectService.findAll();
        if (projectDtos.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return ResponseEntity.ok(projectDtos);
    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение проекта по id")
    @NonNull
    public ResponseEntity<ProjectDto> getById(@PathVariable Integer id) {
        logger.debug("Получение проекта по id");
        ProjectDto projectDto = projectService.findById(id);
        if (projectDto == null) {
            throw new ProjectNotFoundException(id);
        }
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation("Добавляем новый  проект")
    @NonNull
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {
        logger.debug("Добавляем новый проект");
        ProjectDto newProjectDto = projectService.createProject(projectDto);
        return new ResponseEntity<>(newProjectDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные проекта с указанным id")
    @NonNull
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto projectDto,
                                             @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные роекта с id: " + id);
        ProjectDto newProjectDto = projectService.createProject(projectDto);
        return ResponseEntity.ok(newProjectDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем проект с указанным id")
    @NonNull
    public ResponseEntity<ProjectDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем проект с указанным id");
        ProjectDto projectDto = projectService.findById(id);
        if (projectDto == null) {
            throw new ProjectNotFoundException(id);
        }
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
