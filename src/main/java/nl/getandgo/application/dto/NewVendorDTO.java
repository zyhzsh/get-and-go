package nl.getandgo.application.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewVendorDTO {
   private String email;
   private String password;
   private String first_name;
   private String last_name;
   private String avatar_link;
   private String phone;
}
