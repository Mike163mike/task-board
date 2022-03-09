package taskBoard.model.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public enum Role {
    DEVELOPER(Set.of(Permission.READ)),
    AUTHOR(Set.of(Permission.READ, Permission.CREATE, Permission.DELETE, Permission.UPDATE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority() {
        return permissions.stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());
    }
}

