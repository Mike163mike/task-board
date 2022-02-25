package taskBoard.repository;

import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
