package taskBoard.service.dto.request;

import taskBoard.service.dto.response.ProjectPostRequestDto;

import java.util.Objects;

public class BoardPutRequestDto {

    private Integer id;
    private ProjectPostRequestDto projectPostRequestDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProjectPostRequestDto getProject() {
        return projectPostRequestDto;
    }

    public void setProject(ProjectPostRequestDto projectPostRequestDto) {
        this.projectPostRequestDto = projectPostRequestDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPutRequestDto that = (BoardPutRequestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(projectPostRequestDto, that.projectPostRequestDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectPostRequestDto);
    }
}
