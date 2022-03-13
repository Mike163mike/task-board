package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskBoard.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
