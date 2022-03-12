package taskBoard.model.enums;

import java.util.*;

public enum Role {
    GUEST(Set.of(Permission.READ)),
    MODERATOR(Set.of(Permission.READ, Permission.CREATE, Permission.DELETE, Permission.UPDATE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}

