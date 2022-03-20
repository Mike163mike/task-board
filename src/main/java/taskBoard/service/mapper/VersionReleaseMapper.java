package taskBoard.service.mapper;

import java.util.*;

import org.mapstruct.Mapper;
import taskBoard.model.VersionRelease;
import taskBoard.service.dto.request.VersionReleasePostRequestDto;
import taskBoard.service.dto.request.VersionReleasePutRequestDto;
import taskBoard.service.dto.response.VersionReleaseResponseDto;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface VersionReleaseMapper {

    VersionReleaseResponseDto map(VersionRelease versionRelease);

    VersionRelease map(VersionReleasePostRequestDto versionReleasePostRequestDto);

    VersionRelease update(VersionReleasePutRequestDto versionReleasePutRequestDto);

    default Set<VersionReleaseResponseDto> toSet(Set<VersionRelease> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}

