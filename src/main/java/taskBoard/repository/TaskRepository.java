package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
