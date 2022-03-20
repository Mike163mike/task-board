package taskBoard.service.dto.response;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BoardResponseDto {

    private Integer id;
    private ProjectPostRequestDto projectPostRequestDto;
    private Set<TaskResponseDto> tasks = new HashSet<>();

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

    public Set<TaskResponseDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskResponseDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardResponseDto that = (BoardResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(projectPostRequestDto, that.projectPostRequestDto)
                && Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectPostRequestDto, tasks);
    }

    @Override
    public String toString() {
        return "BoardResponseDto{" +
                "id=" + id +
                ", project=" + projectPostRequestDto +
                ", tasks=" + tasks +
                '}';
    }
}
