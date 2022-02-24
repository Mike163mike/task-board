package taskBoard.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import taskBoard.model.Project;
import taskBoard.model.Status;
import taskBoard.model.StatusEntity;
import taskBoard.model.Task;
import taskBoard.service.TaskService;

import java.time.LocalDate;

@Component
public class ProjectUtil {

    Logger logger = LoggerFactory.getLogger(ProjectUtil.class);

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void changeTasksStatusAndCompletionProject(Project project, long id, StatusEntity statusEntity) {
        project.getTask().setStatusEntity(statusEntity);

        logger.debug("Изменение статуса задачи № " + id + " с " + project.getTask().getStatusEntity()
                + " на " + statusEntity);

        int number = 0;
        for (Task task : project.getTasks()) {
            if (task.getStatusEntity().getStatus().equals(Status.BACKLOG)
                    && task.getStatusEntity().getStatus().equals(Status.IN_PROGRESS)) {
                number += 1;
            }
        }
        if (number == 0) {

            logger.debug("Все задачи проекта № " + project.getId() + "выполнены. Проект закрыт и удалён");
        }
    }

    public boolean validateProjectForDelete(Project project) {
        for (Task task : project.getTasks()) {
            if (TaskUtil.taskConditionValidate(task, LocalDate.now())) {
                return false;
            } else
                logger.debug("Все задачи проекта № " + project.getId() + "выполнены. Проект закрыт и удалён");
        }
        return true;
    }

    public int countNumberOfBacklogTask(Project project, StatusEntity statusEntity) {
        int number = 0;
        for (Task taskId : project.getTasks()) {
            if (taskId.getStatusEntity().getStatus().equals(Status.BACKLOG)) {
                number += 1;
            }
        }

        logger.debug("Считаем количество задач со статусом " + statusEntity.getStatus() + " в проекте № " + project.getId()
                + " : " + number);

        return number;
    }

    public int countTasksByStatus(Project project, StatusEntity statusEntity) {
        int number = 0;
        for (Task taskId : project.getTasks()) {
            if (taskId.getStatusEntity().equals(statusEntity)) {
                number += 1;
            }
        }

        logger.debug("Считаем количество задач co статусом " + statusEntity.getStatus() + " в проекте № " + project.getId()
                + " : " + number);

        return number;
    }
}
