package taskBoard.model.enums;

public enum Permission {
    READ("user:read"),
    CREATE("user:create"),
    DELETE("user:delete"),
    UPDATE("user:update");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
