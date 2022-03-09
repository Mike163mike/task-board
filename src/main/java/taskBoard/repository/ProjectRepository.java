package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskBoard.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
