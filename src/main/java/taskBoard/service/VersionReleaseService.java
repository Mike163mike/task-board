package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.VersionRelease;
import taskBoard.repository.VersionReleaseRepository;

@Service
public class VersionReleaseService {

    static Logger logger = LoggerFactory.getLogger(VersionReleaseService.class);

    private final VersionReleaseRepository repository;

    public VersionReleaseService(VersionReleaseRepository repository) {
        this.repository = repository;
    }

    public VersionRelease create(VersionRelease versionRelease) {

        logger.debug("Создаём объект \"VersionRelease\" c id = " + versionRelease.getId());

        return repository.save(versionRelease);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"VersionRelease\" c id = " + id);

        repository.deleteById(id);
    }

    public VersionRelease findById(long id) {

        logger.debug("Ищем объект \"VersionRelease\" с id = " + id);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id = " + id + " was not found"));
    }
}
