package taskBoard.controller;


//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.VersionReleaseService;
import taskBoard.service.dto.request.VersionReleasePostRequestDto;
import taskBoard.service.dto.request.VersionReleasePutRequestDto;
import taskBoard.service.dto.response.VersionReleaseResponseDto;
import taskBoard.service.mapper.VersionReleaseMapper;

import java.util.Set;

@RestController
@RequestMapping("/task-board/version-release")
//@Tag(description = "Version release API", name = "Version release")
public class VersionReleaseController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final VersionReleaseService service;
    private final VersionReleaseMapper mapper;

    public VersionReleaseController(VersionReleaseService service, VersionReleaseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
   // @ApiOperation("Получение множества всех релизов версий")
    public ResponseEntity<Set<VersionReleaseResponseDto>> getAll() {
        logger.debug("Получение списка всех релизов версий");
        Set<VersionReleaseResponseDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/new/{id}")
   // @ApiOperation("Получение релиза версий по id")
    @NonNull
    public ResponseEntity<VersionReleaseResponseDto> getById(@PathVariable Integer id) {
        logger.debug("Получение релиза версий по id");
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }

    @PostMapping
  //  @ApiOperation("Добавляем новый релиз версий")
    @NonNull
    public ResponseEntity<VersionReleaseResponseDto> create(@RequestBody VersionReleasePostRequestDto versionReleasePostRequestDto) {
        logger.debug("Добавляем новый релиз версий");
        VersionReleaseResponseDto newVersionReleaseResponseDto = mapper.map(service.save(mapper.map(versionReleasePostRequestDto)));
        return new ResponseEntity<>(newVersionReleaseResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
  //  @ApiOperation("Обновляем данные релиза версий с указанным id")
    @NonNull
    public ResponseEntity<VersionReleaseResponseDto> update(@RequestBody VersionReleasePutRequestDto versionReleasePutRequestDto,
                                                            @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные релиза версий с id: " + id);
        return ResponseEntity.ok(mapper.map(service.save(mapper.update(versionReleasePutRequestDto))));
    }

    @DeleteMapping("/{id}")
 //   @ApiOperation("Удаляем релиз версий с указанным id")
    @NonNull
    public ResponseEntity<VersionReleaseResponseDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем релиз версий с указанным id");
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

