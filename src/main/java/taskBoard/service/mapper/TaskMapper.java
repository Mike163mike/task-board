package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Task;
import taskBoard.service.dto.request.TaskPostRequestDto;
import taskBoard.service.dto.request.TaskPutRequestDto;
import taskBoard.service.dto.response.TaskResponseDto;

import java.util.*;
import java.util.stream.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponseDto map(Task task);

    Task map(TaskPostRequestDto taskPostRequestDto);

    Task update(TaskPutRequestDto taskPutRequestDto);

    default Set<TaskResponseDto> toSet(Set<Task> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}

