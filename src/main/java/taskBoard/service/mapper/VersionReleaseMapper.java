package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.service.dto.VersionReleaseDto;
import taskBoard.model.VersionRelease;

@Component
public class VersionReleaseMapper {

    public VersionReleaseDto toDto(VersionRelease versionRelease) {
        VersionReleaseDto versionReleaseDto = new VersionReleaseDto();
        versionReleaseDto.setStart(versionRelease.getStartDate());
        versionReleaseDto.setFinish(versionRelease.getFinishDate());
        return versionReleaseDto;
    }

    public VersionRelease toEntity(VersionReleaseDto versionReleaseDto) {
        VersionRelease versionRelease = new VersionRelease();
        versionRelease.setStartDate(versionReleaseDto.getStart());
        versionRelease.setFinishDate(versionReleaseDto.getFinish());
        return versionRelease;
    }
}
