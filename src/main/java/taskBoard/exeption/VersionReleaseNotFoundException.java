package taskBoard.exeption;

public class VersionReleaseNotFoundException extends AppException {

    public VersionReleaseNotFoundException(Integer id) {
        super("VersionRelease with id: " + id + " not found.");
    }

    public VersionReleaseNotFoundException() {
        super("VersionRelease not found.");
    }
}
