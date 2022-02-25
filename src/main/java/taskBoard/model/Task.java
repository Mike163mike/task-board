package taskBoard.model;

import taskBoard.model.enums.Status;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //@Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "author_id")
    private Employee author;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "developer_id")
    private Employee developer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    // @JoinColumn(name = "release_version_id")
    private VersionRelease versionRelease;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    //@JoinColumn(name = "board_id")
    private Board board;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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

}
