package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.service.dto.ProjectDto;
import taskBoard.exeption.EmployeeNotFoundException;
import taskBoard.model.Project;
import taskBoard.repository.ProjectRepository;
import taskBoard.service.mapper.ProjectMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    static Logger logger = LoggerFactory.getLogger(Project.class);

    private final ProjectRepository repository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository repository, ProjectMapper projectMapper) {
        this.repository = repository;
        this.projectMapper = projectMapper;
    }

    public ProjectDto createProject(ProjectDto projectDto) {
        logger.debug("Создаём объект \"Project\"");
        Project entity = projectMapper.toEntity(projectDto);
        Project save = repository.save(entity);
        return projectMapper.toDto(save);

    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Project\" c id = " + id);
        Project project = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        repository.delete(project);
    }

    public ProjectDto findById(Integer id) {
        logger.debug("Ищем объект \"Project\" с id = " + id);
        return projectMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id)));
    }

    public Set<ProjectDto> findAll() {
        logger.debug("Ищем все проекты");
        return repository.findAll().stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toSet());
    }
}


