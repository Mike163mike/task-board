package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Project;
import taskBoard.repository.ProjectRepository;

@Service
public class ProjectService {

    static Logger logger = LoggerFactory.getLogger(Project.class);

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(Project project) {

        logger.debug("Создаём объект \"Project\" c id = " + project.getId());

        return repository.save(project);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"Project\" c id = " + id);

        repository.deleteById(id);
    }

    public Project findById(Long id) {

        logger.debug("Ищем объект \"Project\" с id = " + id);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id = " + id + "was not found"));
    }

}

