package taskBoard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import taskBoard.model.Task;
import taskBoard.model.VersionRelease;
import taskBoard.utilities.TaskUtil;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TaskUtilTest {

    @MockBean
    VersionRelease versionRelease;

    @Test
    public void testTaskConditionValidate(Task task, LocalDate date) {
        versionRelease.setStart(LocalDate.of(2000, 1, 1));
        versionRelease.setFinish(LocalDate.of(2000, 6, 1));
        date = LocalDate.of(2000, 2, 1);
        assertTrue((TaskUtil.taskConditionValidate(task, date)), "Метод \"taskConditionValidate()\" " +
                "из класса" + " \"TaskUtil\" не прошёл тестирование.");
    }

    @Test
    public void testTaskConditionValidate(LocalDate startDate, LocalDate finishDate, LocalDate date) {
        startDate = LocalDate.of(2000, 1, 1);
        finishDate = LocalDate.of(2000, 6, 1);
        date = LocalDate.of(2000, 2, 1);
        assertTrue((TaskUtil.taskConditionValidate(startDate, finishDate, date)), "Метод " +
                "\"taskConditionValidate()\" " + "из класса" + " \"TaskUtil\" не прошёл тестирование.");
    }

    @Test
    public void testPeriodOfReleaseValidate(Task task) {
        versionRelease.setStart(LocalDate.of(2000, 1, 1));
        versionRelease.setFinish(LocalDate.of(2000, 6, 1));
        task.setVersionRelease(versionRelease);
        assertTrue((TaskUtil.periodOfReleaseValidate(task)), "Метод \"periodOfReleaseValidate()\""
                + " из класса" + "  \"TaskUtil\" " + "не прошёл тестирование.");
    }
}
