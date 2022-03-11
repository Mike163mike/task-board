package taskBoard.security;

import org.springframework.stereotype.Component;
import taskBoard.model.enums.Role;

import java.util.Objects;

@Component
public class UserLoginResponse {

    private Integer id;
    private String name;
    private String email;
    private Role role;
    private boolean moderation;
    private int moderationCount;
    private boolean settings;

    public UserLoginResponse() {
    }

    public UserLoginResponse(Integer id, String name, String email, Role role, boolean moderation, int moderationCount, boolean settings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.moderation = moderation;
        this.moderationCount = moderationCount;
        this.settings = settings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isModeration() {
        return moderation;
    }

    public void setModeration(boolean moderation) {
        this.moderation = moderation;
    }

    public int getModerationCount() {
        return moderationCount;
    }

    public void setModerationCount(int moderationCount) {
        this.moderationCount = moderationCount;
    }

    public boolean isSettings() {
        return settings;
    }

    public void setSettings(boolean settings) {
        this.settings = settings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginResponse that = (UserLoginResponse) o;
        return moderation == that.moderation && moderationCount == that.moderationCount && settings == that.settings && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, role, moderation, moderationCount, settings);
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", moderation=" + moderation +
                ", moderationCount=" + moderationCount +
                ", settings=" + settings +
                '}';
    }
}



