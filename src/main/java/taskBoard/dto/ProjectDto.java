package taskBoard.dto;

import org.springframework.stereotype.Component;

@Component
public class ProjectDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
