package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Project;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.repository.ProjectRepository;

import java.util.*;

@Service
public class ProjectService {

    static Logger logger = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project save(Project project) {
        logger.debug("Создаём объект \"Project\"");
        return repository.save(project);

    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Project\" c id = " + id);
        Project project = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        repository.delete(project);
    }

    public Project findById(Integer id) {
        logger.debug("Ищем объект \"Project\" с id = " + id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Set<Project> findAll() {
        logger.debug("Ищем все проекты");
        return new HashSet<>(repository.findAll());
    }
}


