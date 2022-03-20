package taskBoard.service.dto.request;

import taskBoard.model.enums.Status;
import taskBoard.service.dto.response.EmployeeResponseDto;

import java.util.Objects;

public class TaskPutRequestDto {

    private Integer id;
    private String name;
    private Status status;
    private EmployeeResponseDto author;
    private EmployeeResponseDto developer;
    private VersionReleasePostRequestDto versionRelease;
    private BoardPostRequestDto board;

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

    public EmployeeResponseDto getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeResponseDto author) {
        this.author = author;
    }

    public EmployeeResponseDto getDeveloper() {
        return developer;
    }

    public void setDeveloper(EmployeeResponseDto developer) {
        this.developer = developer;
    }

    public VersionReleasePostRequestDto getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(VersionReleasePostRequestDto versionRelease) {
        this.versionRelease = versionRelease;
    }

    public BoardPostRequestDto getBoard() {
        return board;
    }

    public void setBoard(BoardPostRequestDto board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskPutRequestDto that = (TaskPutRequestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && status == that.status && Objects.equals(author, that.author) && Objects.equals(developer, that.developer) && Objects.equals(versionRelease, that.versionRelease) && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, author, developer, versionRelease, board);
    }

    @Override
    public String toString() {
        return "TaskPutRequestDto{" +
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
