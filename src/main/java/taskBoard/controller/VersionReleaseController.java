package taskBoard.controller;


import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import taskBoard.service.dto.VersionReleaseDto;
import taskBoard.exeption.VersionReleaseNotFoundException;
import taskBoard.service.VersionReleaseService;

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
    @ApiOperation("Получение Set'a всех релизов версий")
    @PreAuthorize("hasAuthority('user:read')")
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
    @PreAuthorize("hasAuthority('user:read')")
    @NonNull
    public ResponseEntity<VersionReleaseDto> getById(@PathVariable Long id) {
        logger.debug("Получение релиза версий по id");
        VersionReleaseDto versionReleaseDto = versionReleaseService.findById(id);
        if (versionReleaseDto == null) {
            throw new VersionReleaseNotFoundException(id);
        }
        return ResponseEntity.ok(versionReleaseDto);
    }

    @PostMapping
    @ApiOperation("Добавляем новый релиз версий")
    @PreAuthorize("hasAuthority('user:create')")
    @NonNull
    public ResponseEntity<VersionReleaseDto> create(@RequestBody VersionReleaseDto versionReleaseDto) {
        logger.debug("Добавляем новый релиз версий");
        VersionReleaseDto newVersionReleaseDto = versionReleaseService.createVersionRelease(versionReleaseDto);
        return new ResponseEntity<>(newVersionReleaseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновляем данные релиза версий с указанным id")
    @PreAuthorize("hasAuthority('user:update')")
    @NonNull
    public ResponseEntity<VersionReleaseDto> update(@RequestBody VersionReleaseDto versionReleaseDto,
                                                    @PathVariable("id") Long id) {
        logger.debug("Обновляем данные релиза версий с id: " + id);
        VersionReleaseDto newVersionReleaseDto = versionReleaseService.createVersionRelease(versionReleaseDto);
        return ResponseEntity.ok(newVersionReleaseDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляем релиз версий с указанным id")
    @PreAuthorize("hasAuthority('user:delete')")
    @NonNull
    public ResponseEntity<VersionReleaseDto> deleteById(@PathVariable("id") Long id) {
        logger.debug("Удаляем релиз версий с указанным id");
        VersionReleaseDto versionReleaseDto = versionReleaseService.findById(id);
        if (versionReleaseDto == null) {
            throw new VersionReleaseNotFoundException(id);
        }
        versionReleaseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

