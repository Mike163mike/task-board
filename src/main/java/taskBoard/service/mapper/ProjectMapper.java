package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Project;
import taskBoard.service.dto.ProjectDto;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto toDto(Project project);

    Project toEntity(ProjectDto projectDto);

}
