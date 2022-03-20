package taskBoard.service.dto.request;

import java.util.Objects;

public class ProjectPostRequestDto {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPostRequestDto that = (ProjectPostRequestDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ProjectPostRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
