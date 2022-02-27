package taskBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import taskBoard.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
