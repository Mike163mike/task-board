package taskBoard.repository;

import org.springframework.data.repository.CrudRepository;
import taskBoard.model.VersionRelease;

public interface VersionReleaseRepository extends CrudRepository<VersionRelease, Long> {
}
