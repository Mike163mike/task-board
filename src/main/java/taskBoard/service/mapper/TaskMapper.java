package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.dto.TaskDto;
import taskBoard.model.Task;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();

        taskDto.setName(task.getName());
        taskDto.setStatus(task.getStatus());
        taskDto.setAuthor(task.getAuthor());
        taskDto.setDeveloper((task.getDeveloper()));
        taskDto.setVersionRelease(task.getVersionRelease());
        taskDto.setBoard(task.getBoard());

        return taskDto;
    }

    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();

        task.setName(taskDto.getName());
        task.setStatus(taskDto.getStatus());
        task.setAuthor(taskDto.getAuthor());
        task.setDeveloper(taskDto.getDeveloper());
        task.setVersionRelease(taskDto.getVersionRelease());
        task.setBoard(taskDto.getBoard());

        return task;
    }
}
