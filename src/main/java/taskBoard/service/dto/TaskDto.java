package taskBoard.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import taskBoard.model.enums.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDto {

    private Integer id;
    private String name;
    private Status status;
    private EmployeeDto author;
    private EmployeeDto developer;
    private VersionReleaseDto versionRelease;
    private BoardDto board;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public EmployeeDto getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeDto author) {
        this.author = author;
    }

    public EmployeeDto getDeveloper() {
        return developer;
    }

    public void setDeveloper(EmployeeDto developer) {
        this.developer = developer;
    }

    public VersionReleaseDto getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(VersionReleaseDto versionRelease) {
        this.versionRelease = versionRelease;
    }

    public BoardDto getBoard() {
        return board;
    }

    public void setBoard(BoardDto board) {
        this.board = board;
    }
}
