package taskBoard.service.dto.response;

import java.util.Objects;

public class EmployeeResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private boolean subscription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResponseDto that = (EmployeeResponseDto) o;
        return subscription == that.subscription && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, subscription);
    }

    @Override
    public String toString() {
        return "EmployeeResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subscription=" + subscription +
                '}';
    }
}
