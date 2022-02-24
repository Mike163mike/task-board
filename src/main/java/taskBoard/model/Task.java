package taskBoard.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //  @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "author_id")
    private Employee author;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "developer_id")
    private Employee developer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    // @JoinColumn(name = "release_version_id")
    private VersionRelease versionRelease;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "task")
    private Project project;

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Employee getDeveloper() {
        return developer;
    }

    public void setDeveloper(Employee developer) {
        this.developer = developer;
    }

    public long getId() {
        return id;
    }

    public VersionRelease getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(VersionRelease versionRelease) {
        this.versionRelease = versionRelease;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", statusEntity=" + statusEntity +
                ", author=" + author +
                ", developer=" + developer +
                ", versionRelease=" + versionRelease +
                '}';
    }
}
