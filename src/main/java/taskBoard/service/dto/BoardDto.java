package taskBoard.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDto {
    private Integer id;
    private ProjectDto project;
    private Set<TaskDto> tasks = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(id, boardDto.id) && Objects.equals(project, boardDto.project) && Objects.equals(tasks, boardDto.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, tasks);
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", project=" + project +
                ", tasks=" + tasks +
                '}';
    }
}
