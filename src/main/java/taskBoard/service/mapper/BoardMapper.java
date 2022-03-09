package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.service.dto.BoardDto;
import taskBoard.model.Board;

@Component
public class BoardMapper {

    public BoardDto toDto(Board board) {
        return new BoardDto();
    }

    public Board toEntity(BoardDto boardDto) {
        return new Board();
    }
}
