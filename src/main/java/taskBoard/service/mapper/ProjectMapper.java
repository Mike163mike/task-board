package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.service.dto.request.ProjectPutRequestDto;
import taskBoard.service.dto.response.ProjectPostRequestDto;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectPostRequestDto map(taskBoard.model.Project project);

    taskBoard.model.Project map(taskBoard.service.dto.request.ProjectPostRequestDto projectPostRequestDto);

    taskBoard.model.Project update(ProjectPutRequestDto projectPutRequestDto);

    default Set<ProjectPostRequestDto> toSet(Set<taskBoard.model.Project> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}


