package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Task;
import taskBoard.repository.TaskRepository;

import java.time.LocalDate;

@Service
public class TaskService {

    static Logger logger = LoggerFactory.getLogger(TaskService.class);

    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {

        logger.debug("Создаём объект \"Task\" c id = " + task.getId());

        return repository.save(task);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"Task\" c id = " + id);

        repository.deleteById(id);
    }

    public Task findById(long id) {

        logger.debug("Ищем объект \"Task\" с id = " + id);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id = " + id + " was not found"));
    }
}
