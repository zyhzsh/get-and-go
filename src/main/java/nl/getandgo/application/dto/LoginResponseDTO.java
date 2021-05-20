package nl.getandgo.application.dto;

import lombok.*;

@AllArgsConstructor
public class LoginResponseDTO {
    @Getter @Setter private  String jwt;
    @Getter @Setter private  String user_type;
    @Getter @Setter private  String result;
}
