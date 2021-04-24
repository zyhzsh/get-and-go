package nl.getandgo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NewCustomerDTO {
    @Getter private String email;
    @Getter private String password;
    @Getter private String first_name;
    @Getter private String last_name;
}
