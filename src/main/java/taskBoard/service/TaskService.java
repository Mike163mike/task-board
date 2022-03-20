package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.exeption.TaskNotFoundException;
import taskBoard.model.Task;
import taskBoard.repository.TaskRepository;

import java.util.*;

@Service
public class TaskService {

    static Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task save(Task task) {
        logger.debug("Создаём объект \"Task\"");
        return repository.save(task);
    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Task\" c id: " + id);
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        repository.delete(task);
    }

    public Task findById(Integer id) {
        logger.debug("Ищем объект \"Task\" с id: " + id);
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Set<Task> findAll() {
        logger.debug("Ищем все задачи");
        return new HashSet<>(repository.findAll());
    }
}
