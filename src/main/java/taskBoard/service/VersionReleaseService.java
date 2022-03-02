package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.dto.VersionReleaseDto;
import taskBoard.exeption.VersionReleaseNotFoundException;
import taskBoard.model.VersionRelease;
import taskBoard.repository.VersionReleaseRepository;
import taskBoard.service.mapper.VersionReleaseMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VersionReleaseService {

    static Logger logger = LoggerFactory.getLogger(VersionReleaseService.class);

    private final VersionReleaseRepository repository;
    private final VersionReleaseMapper versionReleaseMapper;

    public VersionReleaseService(VersionReleaseRepository repository, VersionReleaseMapper versionReleaseMapper) {
        this.repository = repository;
        this.versionReleaseMapper = versionReleaseMapper;
    }

    public VersionReleaseDto createVersionRelease(VersionReleaseDto versionReleaseDto) {

        logger.debug("Создаём объект \"VersionRelease\"");

        VersionRelease entity = versionReleaseMapper.toEntity(versionReleaseDto);
        VersionRelease save = repository.save(entity);

        return versionReleaseMapper.toDto(save);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"VersionRelease\" c id = " + id);

        VersionRelease versionRelease = repository.findById(id)
                .orElseThrow(() -> new VersionReleaseNotFoundException(id));

        repository.delete(versionRelease);
    }

    public VersionReleaseDto findById(Long id) {

        logger.debug("Ищем объект \"VersionRelease\" с id = " + id);

        return versionReleaseMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new VersionReleaseNotFoundException(id)));
    }

    public Set<VersionReleaseDto> findAll() {

        logger.debug("Ищем все релизы версий");

        return repository.findAll().stream()
                .map(versionReleaseMapper::toDto)
                .collect(Collectors.toSet());
    }
}
