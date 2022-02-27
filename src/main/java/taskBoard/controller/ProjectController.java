package taskBoard.controller;

import java.util.*;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import taskBoard.model.Project;
import taskBoard.model.Task;
import taskBoard.service.ProjectService;

@RestController
@RequestMapping("/taskBoardProject")
//@Api("Контроллер проекта Доски задач")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    //@RequestParam(value="name", required = fals) String name - не падает, подставляет null
    //добавить в параметры модель Model model спринг внедрит бин в метод
    @GetMapping("/task")
    @ApiOperation("Получение списка всех задач")
    public Set<Task> getAll() {
        return null;
    }

    @GetMapping("/{id}")
   // @ApiOperation("Получение задачи по id")
    public Project findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    //@ApiOperation("Создание новой задачи")
    public void create(@RequestBody Task taskId) {

    }

    @PutMapping("/{id}")
    //@ApiOperation("Обновление задачи по id")
    public void update(@PathVariable long id, @RequestBody Task taskId) {

    }

    @DeleteMapping("/{id}")
   // @ApiOperation("Удаление задачи по ip")
    public void deleteById(@PathVariable long id) {

    }
}
