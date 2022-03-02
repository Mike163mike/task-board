package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.dto.BoardDto;
import taskBoard.exeption.BoardNotFoundException;
import taskBoard.model.Board;
import taskBoard.repository.BoardRepository;
import taskBoard.service.mapper.BoardMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BoardService {

    static Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository repository;
    private final BoardMapper boardMapper;

    public BoardService(BoardRepository repository, BoardMapper boardMapper) {
        this.repository = repository;
        this.boardMapper = boardMapper;
    }

    public BoardDto createBoard(BoardDto boardDto) {

        logger.debug("Создаём объект \"Board\"");

        Board entity = boardMapper.toEntity(boardDto);
        Board save = repository.save(entity);

        return boardMapper.toDto(save);
    }

    public void deleteById(Long id) {

        logger.debug("Удаляем объект \"Board\" c id = " + id);

        Board board = repository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));

        repository.delete(board);
    }

    public BoardDto findById(Long id) {

        logger.debug("Ищем объект \"Board\" с id = " + id);

        return boardMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id)));
    }

    public Set<BoardDto> findAll() {

        logger.debug("Ищем всех сотрудников");

        return repository.findAll().stream()
                .map(boardMapper::toDto)
                .collect(Collectors.toSet());
    }
}
