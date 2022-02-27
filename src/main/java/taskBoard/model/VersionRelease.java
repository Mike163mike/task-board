package taskBoard.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
//@Table(name = "release_version")
public class VersionRelease extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

  //  @Column(name = "start_date")
    private LocalDate start;

    //@Column(name = "finish_date")
    private LocalDate finish;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "versionRelease")
    private List<Task> tasks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
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
        return id == that.id && Objects.equals(start, that.start) && Objects.equals(finish, that.finish) && Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, start, finish, tasks);
    }

    @Override
    public String toString() {
        return "VersionRelease{" +
                "id=" + id +
                ", start=" + start +
                ", finish=" + finish +
                ", taskList=" + tasks +
                '}';
    }
}
