package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.dto.VersionReleaseDto;
import taskBoard.model.VersionRelease;

@Component
public class VersionReleaseMapper {

    public VersionReleaseDto toDto(VersionRelease versionRelease) {
        VersionReleaseDto versionReleaseDto = new VersionReleaseDto();

        versionReleaseDto.setStart(versionRelease.getStart());
        versionReleaseDto.setFinish(versionRelease.getFinish());

        return versionReleaseDto;
    }

    public VersionRelease toEntity(VersionReleaseDto versionReleaseDto) {
        VersionRelease versionRelease = new VersionRelease();

        versionRelease.setStart(versionReleaseDto.getStart());
        versionRelease.setFinish(versionReleaseDto.getFinish());

        return versionRelease;
    }
}
