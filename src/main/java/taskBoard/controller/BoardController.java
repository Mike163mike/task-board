package taskBoard.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.exeption.BoardNotFoundException;
import taskBoard.service.BoardService;
import taskBoard.service.dto.BoardDto;

import java.util.Set;

@RestController
@RequestMapping("/task-board/board")
public class BoardController {

    static Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    @ApiOperation("Получение множества всех досок задач")
    public ResponseEntity<Set<BoardDto>> getAll() {
        logger.debug("Получение списка всех досок задач");
        Set<BoardDto> boardDtos = boardService.findAll();
        if (boardDtos.isEmpty()) {
            throw new BoardNotFoundException();
        }
        return ResponseEntity.ok(boardDtos);
    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение доски задач по id")
    @NonNull
    public ResponseEntity<BoardDto> getById(@PathVariable Long id) {
        logger.debug("Получение доски задач по id");
        BoardDto boardDto = boardService.findById(id);
        if (boardDto == null) {
            throw new BoardNotFoundException(id);
        }
        return ResponseEntity.ok(boardDto);
    }

    @PostMapping
    @ApiOperation("Добавляем новую доску задач")
    @NonNull
    public ResponseEntity<BoardDto> create(@RequestBody BoardDto boardDto) {
        logger.debug("Добавляем новую доску задач");
        BoardDto newBoardDto = boardService.createBoard(boardDto);
        return new ResponseEntity<>(newBoardDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные доски задач с указанным id")
    @NonNull
    public ResponseEntity<BoardDto> update(@RequestBody BoardDto boardDto,
                                           @PathVariable("id") Long id) {
        logger.debug("Обновляем данные доски задач с id: " + id);
        BoardDto newBoardDto = boardService.createBoard(boardDto);
        return ResponseEntity.ok(newBoardDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем доску задач с указанным id")
    @NonNull
    public ResponseEntity<BoardDto> deleteById(@PathVariable("id") Long id) {
        logger.debug("Удаляем доску задач с указанным id");
        BoardDto boardDto = boardService.findById(id);
        if (boardDto == null) {
            throw new BoardNotFoundException(id);
        }
        boardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

