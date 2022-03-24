package taskBoard.controller;

//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.BoardService;
import taskBoard.service.dto.response.BoardResponseDto;
import taskBoard.service.dto.request.BoardPostRequestDto;
import taskBoard.service.dto.request.BoardPutRequestDto;
import taskBoard.service.mapper.BoardMapper;

import java.util.Set;

@RestController
@RequestMapping("/task-board/board")
//@Tag(description = "Board API", name = "board")
public class BoardController {

    static Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService service;
    private final BoardMapper mapper;

    public BoardController(BoardService service, BoardMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
   // @ApiOperation("Получение множества всех досок задач")
    public ResponseEntity<Set<BoardResponseDto>> getAll() {
        logger.debug("Получение списка всех досок задач");
        Set<BoardResponseDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/new/{id}")
   // @ApiOperation("Получение доски задач по id")
    @NonNull
    public ResponseEntity<BoardResponseDto> getById(@PathVariable Integer id) {
        logger.debug("Получение доски задач по id");
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }

    @PostMapping
   // @ApiOperation("Добавляем новую доску задач")
    @NonNull
    public ResponseEntity<BoardResponseDto> create(@RequestBody BoardPostRequestDto boardPostRequestDto) {
        logger.debug("Добавляем новую доску задач");
        BoardResponseDto newBoardResponseDto = mapper.map(service.save(mapper.map(boardPostRequestDto)));
        return new ResponseEntity<>(newBoardResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   // @ApiOperation("Обновляем данные доски задач с указанным id")
    @NonNull
    public ResponseEntity<BoardResponseDto> update(@RequestBody BoardPutRequestDto boardPutRequestDto,
                                                   @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные доски задач с id: " + id);
        return ResponseEntity.ok(mapper.map(service.save(mapper.update(boardPutRequestDto))));
    }

    @DeleteMapping("/{id}")
   // @ApiOperation("Удаляем доску задач с указанным id")
    @NonNull
    public ResponseEntity<BoardResponseDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем доску задач с указанным id");
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

