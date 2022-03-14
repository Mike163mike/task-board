package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Task;
import taskBoard.service.dto.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}
