package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Board;
import taskBoard.service.dto.BoardDto;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto toDto(Board board);

    Board toEntity(BoardDto boardDto);
}
