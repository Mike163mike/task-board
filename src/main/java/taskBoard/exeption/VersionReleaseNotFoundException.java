package taskBoard.exeption;

public class VersionReleaseNotFoundException extends AppException {

    public VersionReleaseNotFoundException(Long id) {
        super("VersionRElease with id: " + id + " not found.");
    }

    public VersionReleaseNotFoundException() {
        super("VersionRelease not found.");
    }
}
