package taskBoard.service.dto.request;

import java.time.LocalDate;
import java.util.Objects;

public class VersionReleasePutRequestDto {

    private Integer id;
    private LocalDate finishDate;
    private LocalDate startDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionReleasePutRequestDto that = (VersionReleasePutRequestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(finishDate, that.finishDate) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, finishDate, startDate);
    }

    @Override
    public String toString() {
        return "VersionReleasePutRequestDto{" +
                "id=" + id +
                ", finishDate=" + finishDate +
                ", startDate=" + startDate +
                '}';
    }
}
