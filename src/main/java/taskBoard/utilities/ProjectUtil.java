package taskBoard.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taskBoard.model.Project;

public class ProjectUtil {

    static Logger logger = LoggerFactory.getLogger(ProjectUtil.class);

    private Project project;

    public static boolean closeProjectIfAllTasksAreDone(Project project) {
        return project.getBoards().isEmpty();
    }

}
