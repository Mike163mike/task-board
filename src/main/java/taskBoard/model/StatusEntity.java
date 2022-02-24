package taskBoard.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
//@Table(name = "status")
//@Component
public class StatusEntity {

    //  @Column(name = "status")
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "statusEntity")
    //@JoinColumn(name = "task")
    private Task task;

    @Id
    @NonNull
    private int id = status.ordinal();

    public Task getTask() {
        return task;
    }

    public void setTask(Task taskId) {
        this.task = taskId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" +  id +
                ", status=" + status +
                '}';
    }
}
