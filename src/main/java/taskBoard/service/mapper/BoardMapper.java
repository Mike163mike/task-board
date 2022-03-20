package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Board;
import taskBoard.service.dto.response.BoardResponseDto;
import taskBoard.service.dto.request.BoardPostRequestDto;
import taskBoard.service.dto.request.BoardPutRequestDto;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardResponseDto map(Board board);

    Board map(BoardPostRequestDto boardPostRequestDto);

    Board update(BoardPutRequestDto boardPutRequestDto);

    default Set<BoardResponseDto> toSet(Set<Board> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}
