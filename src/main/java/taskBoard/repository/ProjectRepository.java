package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
