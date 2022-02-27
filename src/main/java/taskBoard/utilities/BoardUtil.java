package taskBoard.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import taskBoard.model.*;
import taskBoard.model.enums.Status;

import java.time.LocalDate;

@Component
public class BoardUtil {

    static Logger logger = LoggerFactory.getLogger(BoardUtil.class);

    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static boolean changeTasksStatusAndDeleteBoard(Board board, long id, Status status) {

        Task tempTask = TaskUtil.getTaskById(board.getTasks(), id);

        if (tempTask != null) {
            tempTask.setStatus(status);
        } else {
            throw new RuntimeException("That task is not exist");
        }

        logger.debug("Изменение статуса задачи № " + id + " на " + status);

        int number = 0;
        for (Task task : board.getTasks()) {
            if (task.getStatus().equals(Status.BACKLOG)
                    && task.getStatus().equals(Status.IN_PROGRESS)) {
                number += 1;
            }
        }
        if (number == 0) {

            logger.debug("Все задачи доски № " + board.getId() + "выполнены.");

            return true;
        }
        return false;
    }

    public static boolean validateProjectForDelete(Board board) {
        for (Task task : board.getTasks()) {
            if (TaskUtil.taskConditionValidate(task, LocalDate.now())) {
                return false;
            } else
                logger.debug("Считаем: все ли задачи доски № " + board.getId() + "выполнены?");
        }
        return true;
    }

    public static int countNumberOfBacklogTask(Board board) {
        int number = 0;
        for (Task task : board.getTasks()) {
            if (task.getStatus().equals(Status.BACKLOG)) {
                number += 1;
            }
        }

        logger.debug("Считаем количество задач со статусом " + Status.BACKLOG + " на доске № " + board.getId()
                + " : " + number);

        return number;
    }

    public static int countTasksByStatus(Board board, Status status) {
        int number = 0;
        for (Task task : board.getTasks()) {
            if (task.getStatus().equals(status)) {
                number += 1;
            }
        }

        logger.debug("Считаем количество задач co статусом " + status + " на доске № " + board.getId()
                + " : " + number);

        return number;
    }
}
