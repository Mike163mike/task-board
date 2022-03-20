package taskBoard.service.dto.response;

import taskBoard.service.dto.request.TaskPostRequestDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VersionReleaseResponseDto {

    private Integer id;
    private LocalDate finishDate;
    private LocalDate startDate;
    private List<TaskPostRequestDto> taskPostRequestDtos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<TaskPostRequestDto> getTaskPostRequestDtos() {
        return taskPostRequestDtos;
    }

    public void setTaskPostRequestDtos(List<TaskPostRequestDto> taskPostRequestDtos) {
        this.taskPostRequestDtos = taskPostRequestDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionReleaseResponseDto that = (VersionReleaseResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(finishDate, that.finishDate) && Objects.equals(startDate, that.startDate) && Objects.equals(taskPostRequestDtos, that.taskPostRequestDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, finishDate, startDate, taskPostRequestDtos);
    }

    @Override
    public String toString() {
        return "VersionReleaseResponseDto{" +
                "id=" + id +
                ", finishDate=" + finishDate +
                ", startDate=" + startDate +
                ", taskPostRequestDtos=" + taskPostRequestDtos +
                '}';
    }
}
