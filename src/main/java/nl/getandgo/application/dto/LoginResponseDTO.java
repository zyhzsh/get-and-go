package nl.getandgo.application.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginResponseDTO {
      private  String jwt;
      private  String user_type;
      private  String result;
      private  UserProfileDTO user;
}
