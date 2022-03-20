package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.exeption.BoardNotFoundException;
import taskBoard.model.Board;
import taskBoard.repository.BoardRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class BoardService {

    static Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public Board save(Board board) {
        logger.debug("Сохраняем объект \"Board\"");
        return repository.save(board);
    }

    public void deleteById(Integer id) {
        logger.debug("Удаляем объект \"Board\" c id = " + id);
        Board board = repository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));
        repository.delete(board);
    }

    public Board findById(Integer id) {
        logger.debug("Ищем объект \"Board\" с id = " + id);
        return repository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));
    }

    public Set<Board> findAll() {
        logger.debug("Ищем всех сотрудников");
        return new HashSet<>(repository.findAll());
    }
}
