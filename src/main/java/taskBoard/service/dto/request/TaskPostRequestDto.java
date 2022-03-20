package taskBoard.service.dto.request;

import taskBoard.model.enums.Status;

import java.util.Objects;

public class TaskPostRequestDto {

    private String name;
    private Status status;
    private VersionReleasePostRequestDto versionRelease;
    private BoardPostRequestDto board;

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
        TaskPostRequestDto that = (TaskPostRequestDto) o;
        return Objects.equals(name, that.name) && status == that.status && Objects.equals(versionRelease, that.versionRelease) && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, versionRelease, board);
    }

    @Override
    public String toString() {
        return "TaskPostRequestDto{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", versionRelease=" + versionRelease +
                ", board=" + board +
                '}';
    }
}
