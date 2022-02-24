package taskBoard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskBoard.model.Task;

import java.time.LocalDate;

@Service
public class TaskService {

    Logger logger = LoggerFactory.getLogger(TaskService.class);

    public Task createTask() {

        logger.debug("Создаём объект \"Task\"");
        return null;
    }

    public void updateTask(Task taskId) {

        logger.debug("Обновляем объект \"Task\"");
    }


}
