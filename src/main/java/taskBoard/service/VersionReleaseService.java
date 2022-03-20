package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.service.dto.response.VersionReleaseResponseDto;
import taskBoard.exeption.VersionReleaseNotFoundException;
import taskBoard.model.VersionRelease;
import taskBoard.repository.VersionReleaseRepository;

import java.util.*;

@Service
public class VersionReleaseService {

    static Logger logger = LoggerFactory.getLogger(VersionReleaseService.class);

    private final VersionReleaseRepository repository;

    public VersionReleaseService(VersionReleaseRepository repository) {
        this.repository = repository;
    }

    public VersionRelease save(VersionRelease versionRelease) {
        logger.debug("Создаём объект \"VersionRelease\"");
        return repository.save(versionRelease);
    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"VersionRelease\" c id = " + id);
        VersionRelease versionRelease = repository.findById(id)
                .orElseThrow(() -> new VersionReleaseNotFoundException(id));
        repository.delete(versionRelease);
    }

    public VersionRelease findById(Integer id) {
        logger.debug("Ищем объект \"VersionRelease\" с id = " + id);
        return repository.findById(id)
                .orElseThrow(() -> new VersionReleaseNotFoundException(id));
    }

    public Set<VersionRelease> findAll() {
        logger.debug("Ищем все релизы версий");
        return new HashSet<>(repository.findAll());
    }
}
