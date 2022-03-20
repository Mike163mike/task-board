package taskBoard.service.dto.response;

import java.util.Objects;

public class ProjectPostRequestDto {

    private Integer id;
    private String name;
    private BoardResponseDto board;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BoardResponseDto getBoard() {
        return board;
    }

    public void setBoard(BoardResponseDto board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPostRequestDto that = (ProjectPostRequestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, board);
    }

    @Override
    public String toString() {
        return "ProjectResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", board=" + board +
                '}';
    }
}
