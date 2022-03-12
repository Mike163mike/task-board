package taskBoard.model;

import taskBoard.model.enums.Status;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Employee author;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id")
    private Employee developer;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "version_release_id")
    private VersionRelease versionRelease;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Employee getDeveloper() {
        return developer;
    }

    public void setDeveloper(Employee developer) {
        this.developer = developer;
    }

    public Integer getId() {
        return id;
    }

    public VersionRelease getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(VersionRelease versionRelease) {
        this.versionRelease = versionRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && status == task.status && Objects.equals(author, task.author) && Objects.equals(developer, task.developer) && Objects.equals(versionRelease, task.versionRelease) && Objects.equals(board, task.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, author, developer, versionRelease, board);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", author=" + author +
                ", developer=" + developer +
                ", versionRelease=" + versionRelease +
                ", board=" + board +
                '}';
    }
}
