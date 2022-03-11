package taskBoard.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoginResponse {

    private boolean result;

    @JsonProperty("user")
    private UserLoginResponse userLoginResponse;

    public LoginResponse() {
    }

    public LoginResponse(boolean result, UserLoginResponse userLoginResponse) {
        this.result = result;
        this.userLoginResponse = userLoginResponse;
    }

    public UserLoginResponse getUserLoginResponse() {
        return userLoginResponse;
    }

    public void setUserLoginResponse(UserLoginResponse userLoginResponse) {
        this.userLoginResponse = userLoginResponse;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponse that = (LoginResponse) o;
        return result == that.result && Objects.equals(userLoginResponse, that.userLoginResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, userLoginResponse);
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "result=" + result +
                ", userLoginResponse=" + userLoginResponse +
                '}';
    }
}
