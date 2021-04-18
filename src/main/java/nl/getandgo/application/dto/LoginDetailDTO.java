package nl.getandgo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class LoginDetailDTO {
    @Getter private String email;
    @Getter private String password;
}
