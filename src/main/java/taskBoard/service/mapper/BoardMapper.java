package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.service.dto.BoardDto;
import taskBoard.model.Board;

@Component
public class BoardMapper {

    public BoardDto toDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        return boardDto;
    }

    public Board toEntity(BoardDto boardDto) {
        return new Board();
    }
}
