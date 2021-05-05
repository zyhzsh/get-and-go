package nl.getandgo.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class LoginResponseDTO {
    @Getter @Setter private final String jwt;
}
