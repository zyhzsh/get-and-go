package nl.getandgo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
    @Getter @Setter private String email;
    @Getter @Setter private String password;

}
