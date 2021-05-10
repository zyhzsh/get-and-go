package nl.getandgo.application.dto;

import lombok.*;

@AllArgsConstructor
public class LoginResponseDTO {
    @Getter @Setter private final String jwt;
    @Getter @Setter private final String user_type;
    @Getter @Setter private final String result;
}
