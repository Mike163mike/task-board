package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.service.dto.TaskDto;
import taskBoard.exeption.TaskNotFoundException;
import taskBoard.model.Task;
import taskBoard.repository.TaskRepository;
import taskBoard.service.mapper.TaskMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {

    static Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository repository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository repository, TaskMapper taskMapper) {
        this.repository = repository;
        this.taskMapper = taskMapper;
    }

    public TaskDto createTask(TaskDto taskDto) {
        logger.debug("Создаём объект \"Task\"");
        Task entity = taskMapper.toEntity(taskDto);
        Task save = repository.save(entity);
        return taskMapper.toDto(save);
    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Task\" c id: " + id);
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        repository.delete(task);
    }

    public TaskDto findById(Integer id) {
        logger.debug("Ищем объект \"Task\" с id: " + id);
        return taskMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    public Set<TaskDto> findAll() {
        logger.debug("Ищем все задачи");
        return repository.findAll().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toSet());
    }
}
