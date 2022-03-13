package taskBoard.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import taskBoard.model.enums.Role;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }
}
