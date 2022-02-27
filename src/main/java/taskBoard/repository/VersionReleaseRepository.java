package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import taskBoard.model.VersionRelease;

public interface VersionReleaseRepository extends JpaRepository<VersionRelease, Long> {
}
