package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskBoard.dto.ProjectDto;
import taskBoard.exeption.ProjectNotFoundException;
import taskBoard.service.ProjectService;

import java.util.Set;

@RestController
@RequestMapping("task-board/project")
public class ProjectController {

    static Logger logger = LoggerFactory.getLogger(taskBoard.controller.EmployeeController.class);

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @ApiOperation("Получение списка всех проектов")
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
    public ResponseEntity<ProjectDto> getById(@PathVariable Long id) {

        logger.debug("Получение проекта по id");

        if (id == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProjectDto projectDto = projectService.findById(id);

        if (projectDto == null) {

            throw new ProjectNotFoundException(id);
        }

        return ResponseEntity.ok(projectDto);
    }


    @PostMapping
    @ApiOperation("Добавляем новый  проект")
    public ResponseEntity<ProjectDto> create(@ModelAttribute("projectDto") ProjectDto projectDto) {

        logger.debug("Добавляем новый проект");

        if (projectDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProjectDto newProjectDto = projectService.createProject(projectDto);

        return new ResponseEntity<>(newProjectDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные проекта с указанным id")
    public ResponseEntity<ProjectDto> update(@ModelAttribute("project") ProjectDto projectDto,
                                             @PathVariable("id") Long id) {

        logger.debug("Обновляем данные роекта с id: " + id);

        if (id == null || projectDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProjectDto newProjectDto = projectService.createProject(projectDto);

        return ResponseEntity.ok(newProjectDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем проект с указанным id")
    public ResponseEntity<ProjectDto> deleteById(@PathVariable("id") Long id) {

        logger.debug("Удаляем проект с указанным id");

        ProjectDto projectDto = projectService.findById(id);
        if (projectDto == null) {
            throw new ProjectNotFoundException(id);
        }

        projectService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
