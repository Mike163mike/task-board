package taskBoard.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taskBoard.model.Task;

import java.time.LocalDate;

public class TaskUtil {

    Logger logger = LoggerFactory.getLogger(TaskUtil.class);

    public static boolean taskConditionValidate(Task task, LocalDate date) {
        return date.isAfter(task.getVersionRelease().getStart()) && date.isBefore(task.getVersionRelease().getFinish());
    }

    public static boolean taskConditionValidate(LocalDate startDate, LocalDate finishDate, LocalDate date) {
        return date.isAfter(startDate) && date.isBefore(finishDate);
    }

    public boolean periodOfReleaseValidate(Task task) {
        return task.getVersionRelease().getStart().isBefore(task.getVersionRelease().getFinish());
    }

}
