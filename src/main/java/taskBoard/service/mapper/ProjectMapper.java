package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.dto.ProjectDto;
import taskBoard.model.Project;

@Component
public class ProjectMapper {

    public ProjectDto toDto(Project project) {
       ProjectDto projectDto = new ProjectDto();

        projectDto.setName(project.getName());

        return projectDto;
    }

    public Project toEntity(ProjectDto projectDto) {
        Project project = new Project();

        project.setName(projectDto.getName());

        return project;
    }
}
