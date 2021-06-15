package nl.getandgo.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequestDTO {
    private String email;
    private String password;

}
