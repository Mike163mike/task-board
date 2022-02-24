package taskBoard.model;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
//@Component
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToOne
    private Task task;

    @Transient
    private Set<Task> tasks = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task taskId) {
        this.task = taskId;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
