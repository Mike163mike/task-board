package taskBoard.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taskBoard.model.Task;
import taskBoard.model.enums.Status;

import java.util.*;

import java.time.LocalDate;

public class TaskUtil {

    static Logger logger = LoggerFactory.getLogger(TaskUtil.class);

    public static boolean taskConditionValidate(Task task, LocalDate date) {

        logger.debug("Проверяем дату " + date + " на вхождение в интервал релиза c id = " + task.getVersionRelease().getId());

        return date.isAfter(task.getVersionRelease().getStart()) && date.isBefore(task.getVersionRelease().getFinish());
    }

    public static boolean taskConditionValidate(LocalDate startDate, LocalDate finishDate, LocalDate date) {

        logger.debug("Проверяем дату " + date + " на вхождение в интервал: с " + startDate + " по " + finishDate);

        return date.isAfter(startDate) && date.isBefore(finishDate);
    }

    public static boolean periodOfReleaseValidate(Task task) {

        logger.debug("Проверяем корректность задания дат релиза");

        return task.getVersionRelease().getStart().isBefore(task.getVersionRelease().getFinish());
    }

    public static Task getTaskById(Set<Task> tasks, long id) {
        for (Task task:tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static void changeTaskStatus(Task task, Status status) {
         task.setStatus(status);
    }

}
