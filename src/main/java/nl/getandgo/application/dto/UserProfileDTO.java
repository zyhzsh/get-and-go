package nl.getandgo.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserProfileDTO {
    private Long user_id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar_link;
    private String phone;
}
