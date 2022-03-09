package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskBoard.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
