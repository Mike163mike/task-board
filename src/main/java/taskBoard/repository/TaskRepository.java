package taskBoard.repository;

import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Project;
import taskBoard.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
