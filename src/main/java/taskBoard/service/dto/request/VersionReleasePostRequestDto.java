package taskBoard.service.dto.request;

import java.time.LocalDate;
import java.util.Objects;

public class VersionReleasePostRequestDto {

    private LocalDate finishDate;
    private LocalDate startDate;

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
        VersionReleasePostRequestDto that = (VersionReleasePostRequestDto) o;
        return Objects.equals(finishDate, that.finishDate) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finishDate, startDate);
    }

    @Override
    public String toString() {
        return "VersionReleasePostRequestDto{" +
                "finishDate=" + finishDate +
                ", startDate=" + startDate +
                '}';
    }
}
