package taskBoard.model;

import taskBoard.model.enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean subscription;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Task> authorsTasks = new HashSet<>();

    @OneToMany(mappedBy = "developer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Task> developersTasks = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public Set<Task> getAuthorsTasks() {
        return authorsTasks;
    }

    public void setAuthorsTasks(Set<Task> authorsTasks) {
        this.authorsTasks = authorsTasks;
    }

    public Set<Task> getDevelopersTasks() {
        return developersTasks;
    }

    public void setDevelopersTasks(Set<Task> developersTasks) {
        this.developersTasks = developersTasks;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
