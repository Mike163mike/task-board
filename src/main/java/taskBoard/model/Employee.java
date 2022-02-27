package taskBoard.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;

    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Task> authorsTasks = new HashSet<>();

    @OneToMany(mappedBy = "developer")
    private Set<Task> developersTasks = new HashSet<>();

    @Transient
    private Set<Employee> employees = new HashSet<>();

    public long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name) && Objects.equals(authorsTasks, employee.authorsTasks) && Objects.equals(developersTasks, employee.developersTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, authorsTasks, developersTasks);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
