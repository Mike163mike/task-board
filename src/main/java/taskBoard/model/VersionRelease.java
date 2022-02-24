package taskBoard.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
//@Table(name = "release_version")
//@Component
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
    public String toString() {
        return "VersionRelease{" +
                "id=" + id +
                ", start=" + start +
                ", finish=" + finish +
                ", taskList=" + tasks +
                '}';
    }
}
