package taskBoard.controller;


import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import taskBoard.exeption.VersionReleaseNotFoundException;
import taskBoard.service.VersionReleaseService;
import taskBoard.service.dto.VersionReleaseDto;

import java.util.Set;

@RestController
@RequestMapping("/task-board/version-release")
public class VersionReleaseController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final VersionReleaseService versionReleaseService;

    public VersionReleaseController(VersionReleaseService versionReleaseService) {
        this.versionReleaseService = versionReleaseService;
    }

    @GetMapping
    @ApiOperation("Получение множества всех релизов версий")
    public ResponseEntity<Set<VersionReleaseDto>> getAll() {
        logger.debug("Получение списка всех релизов версий");
        Set<VersionReleaseDto> versionReleaseDtos = versionReleaseService.findAll();
        if (versionReleaseDtos.isEmpty()) {
            throw new VersionReleaseNotFoundException();
        }
        return ResponseEntity.ok(versionReleaseDtos);
    }

    @GetMapping("/new/{id}")
    @ApiOperation("Получение релиза версий по id")
    @NonNull
    public ResponseEntity<VersionReleaseDto> getById(@PathVariable Integer id) {
        logger.debug("Получение релиза версий по id");
        VersionReleaseDto versionReleaseDto = versionReleaseService.findById(id);
        if (versionReleaseDto == null) {
            throw new VersionReleaseNotFoundException(id);
        }
        return ResponseEntity.ok(versionReleaseDto);
    }

    @PostMapping
    @ApiOperation("Добавляем новый релиз версий")
    @NonNull
    public ResponseEntity<VersionReleaseDto> create(@RequestBody VersionReleaseDto versionReleaseDto) {
        logger.debug("Добавляем новый релиз версий");
        VersionReleaseDto newVersionReleaseDto = versionReleaseService.createVersionRelease(versionReleaseDto);
        return new ResponseEntity<>(newVersionReleaseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные релиза версий с указанным id")
    @NonNull
    public ResponseEntity<VersionReleaseDto> update(@RequestBody VersionReleaseDto versionReleaseDto,
                                                    @PathVariable("id") Integer id) {
        logger.debug("Обновляем данные релиза версий с id: " + id);
        VersionReleaseDto newVersionReleaseDto = versionReleaseService.createVersionRelease(versionReleaseDto);
        return ResponseEntity.ok(newVersionReleaseDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем релиз версий с указанным id")
    @NonNull
    public ResponseEntity<VersionReleaseDto> deleteById(@PathVariable("id") Integer id) {
        logger.debug("Удаляем релиз версий с указанным id");
        VersionReleaseDto versionReleaseDto = versionReleaseService.findById(id);
        if (versionReleaseDto == null) {
            throw new VersionReleaseNotFoundException(id);
        }
        versionReleaseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

