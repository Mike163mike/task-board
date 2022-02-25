package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Board;
import taskBoard.repository.BoardRepository;

@Service
public class BoardService {

    static Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public Board create(Board board) {
        logger.debug("Создаём объект \"Board\" c id = " + board.getId());
        return repository.save(board);
    }

    public void deleteById(Long id) {
        logger.debug("Удаляем объект \"Board\" c id = " + id);
        repository.deleteById(id);
    }

    public Board findById(long id) {
        logger.debug("Ищем объект \"Board\" с id = " + id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board with id = " + id + " was not found"));
    }
}
