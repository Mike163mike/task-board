package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.service.dto.VersionReleaseDto;
import taskBoard.model.VersionRelease;

@Component
public class VersionReleaseMapper {

    public VersionReleaseDto toDto(VersionRelease versionRelease) {
        VersionReleaseDto versionReleaseDto = new VersionReleaseDto();
        versionReleaseDto.setStartDate(versionRelease.getStartDate());
        versionReleaseDto.setFinishDate(versionRelease.getFinishDate());
        return versionReleaseDto;
    }

    public VersionRelease toEntity(VersionReleaseDto versionReleaseDto) {
        VersionRelease versionRelease = new VersionRelease();
        versionRelease.setStartDate(versionReleaseDto.getStartDate());
        versionRelease.setFinishDate(versionReleaseDto.getFinishDate());
        return versionRelease;
    }
}
