package taskBoard.repository;

import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
