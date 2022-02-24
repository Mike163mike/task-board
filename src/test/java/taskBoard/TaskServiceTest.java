package taskBoard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import taskBoard.service.TaskService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TaskServiceTest {

    @MockBean
    TaskService taskUtil;

//    @Test
//    public void testTaskConditionValidate() {
//        taskUtil.getTask().getVersionRelease().setStart(LocalDate.of(2000, 1, 1));
//        taskUtil.getTask().getVersionRelease().setFinish(LocalDate.of(2000, 6, 1));
//        LocalDate date = LocalDate.of(2000, 2, 1);
//        assertTrue(taskUtil.(taskUtil.getTask(), date), "Метод \"taskConditionValidate()\" " +
//                "из класса" + " \"TaskService\" не прошёл тестирование.");
//    }
//
//    @Test
//    public void testPeriodOfReleaseValidate() {
//        taskUtil.getTask().getVersionRelease().setStart(LocalDate.of(2000, 1, 1));
//        taskUtil.getTask().getVersionRelease().setFinish(LocalDate.of(2000, 6, 1));
//        assertTrue(taskUtil.periodOfReleaseValidate(taskUtil.getTask()), "Метод \"periodOfReleaseValidate()\"" +
//                " из класса" + "  \"Task\" " + "не прошёл тестирование.");
//    }
}
