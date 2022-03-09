package taskBoard.model;

import taskBoard.model.enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Task> authorsTasks = new HashSet<>();

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private Set<Task> developersTasks = new HashSet<>();

    @Transient
    private Set<Employee> employees = new HashSet<>();

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && role == employee.role && Objects.equals(authorsTasks, employee.authorsTasks) && Objects.equals(developersTasks, employee.developersTasks) && Objects.equals(employees, employee.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, email, password, role, authorsTasks, developersTasks, employees);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
