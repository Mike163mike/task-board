package taskBoard.service;

import org.springframework.stereotype.Service;
import taskBoard.model.Project;
import taskBoard.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(Project project) {
        return repository.save(project);
    }

    public void delete(Project project) {
        repository.delete(project);
    }

    public Project findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project was not found"));
    }

}

