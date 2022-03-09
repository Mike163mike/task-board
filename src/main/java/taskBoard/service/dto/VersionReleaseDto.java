package taskBoard.service.dto;

import java.time.LocalDate;

public class VersionReleaseDto {

    private LocalDate finish;
    private LocalDate start;

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }
}
