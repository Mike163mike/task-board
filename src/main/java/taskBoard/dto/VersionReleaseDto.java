package taskBoard.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
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
