package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.VersionRelease;
import taskBoard.service.dto.VersionReleaseDto;

@Mapper(componentModel = "spring")
public interface VersionReleaseMapper {

    VersionReleaseDto toDto(VersionRelease versionRelease);

    VersionRelease toEntity(VersionReleaseDto versionReleaseDto);
}
