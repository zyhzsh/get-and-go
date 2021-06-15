package nl.getandgo.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewCustomerDTO {
     private String email;
     private String password;
     private String first_name;
     private String last_name;
}
