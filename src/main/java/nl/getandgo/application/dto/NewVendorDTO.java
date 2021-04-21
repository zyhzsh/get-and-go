package nl.getandgo.application.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NewVendorDTO {
  @Getter private String email;
  @Getter private String password;
  @Getter private String first_name;
  @Getter private String last_name;
  @Getter private String avatar_link;
  @Getter private String phone;
}
