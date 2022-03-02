package taskBoard.dto;

import org.springframework.stereotype.Component;
import taskBoard.model.Board;
import taskBoard.model.Employee;
import taskBoard.model.VersionRelease;
import taskBoard.model.enums.Status;

@Component
public class TaskDto {

    private String name;
    private Status status;
    private Employee author;
    private Employee developer;
    private VersionRelease versionRelease;
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

    public VersionRelease getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(VersionRelease versionRelease) {
        this.versionRelease = versionRelease;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
