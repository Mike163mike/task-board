package taskBoard.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    // @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    private Set<Task> tasks = new HashSet<>();

    public long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return id == board.id && Objects.equals(project, board.project) && Objects.equals(tasks, board.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, tasks);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", project=" + project +
                ", tasks=" + tasks +
                '}';
    }
}