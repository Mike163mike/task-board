package taskBoard.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "version_release")
public class VersionRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "versionRelease", cascade = CascadeType.REFRESH)
    private List<Task> tasks = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate start) {
        this.startDate = start;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finish) {
        this.finishDate = finish;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> taskIdList) {
        this.tasks = taskIdList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VersionRelease that = (VersionRelease) o;
        return Objects.equals(id, that.id) && Objects.equals(startDate, that.startDate) && Objects.equals(finishDate, that.finishDate) && Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, startDate, finishDate, tasks);
    }

    @Override
    public String toString() {
        return "VersionRelease{" +
                "id=" + id +
                ", start=" + startDate +
                ", finish=" + finishDate +
                ", taskList=" + tasks +
                '}';
    }
}
