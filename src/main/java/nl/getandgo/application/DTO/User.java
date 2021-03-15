package nl.getandgo.application.DTO;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter private String username;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private AccountType accountype;

    public enum AccountType{
        normal,admin,vendor
    }

    public User(String username, String email, String password, AccountType accountype) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.accountype = accountype;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", accountype=" + accountype +
                '}';
    }
}
