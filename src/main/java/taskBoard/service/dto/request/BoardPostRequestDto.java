package taskBoard.service.dto.request;

import java.util.Objects;

public class BoardPostRequestDto {

    private ProjectPostRequestDto projectPostRequestDto;

    public ProjectPostRequestDto getProjectPostRequestDto() {
        return projectPostRequestDto;
    }

    public void setProjectPostRequestDto(ProjectPostRequestDto projectPostRequestDto) {
        this.projectPostRequestDto = projectPostRequestDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPostRequestDto that = (BoardPostRequestDto) o;
        return Objects.equals(projectPostRequestDto, that.projectPostRequestDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectPostRequestDto);
    }

    @Override
    public String toString() {
        return "BoardPostRequestDto{" +
                "projectDto=" + projectPostRequestDto +
                '}';
    }
}
