package nl.getandgo.application.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class LoginInFoDTO {
    @Getter private String email;
    @Getter private String password;

}
