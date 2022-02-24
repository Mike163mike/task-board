package taskBoard.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String surname;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Task> authorsTasks = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    private List<Task> developersTasks = new ArrayList<>();


//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    private Employee developer;

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

    public List<Task> getAuthorsTasks() {
        return authorsTasks;
    }

    public void setAuthorsTasks(List<Task> authorsTasks) {
        this.authorsTasks = authorsTasks;
    }

    public List<Task> getDevelopersTasks() {
        return developersTasks;
    }

    public void setDevelopersTasks(List<Task> developersTasks) {
        this.developersTasks = developersTasks;
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
