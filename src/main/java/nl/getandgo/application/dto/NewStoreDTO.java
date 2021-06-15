package nl.getandgo.application.dto;
import lombok.*;
import nl.getandgo.application.model.City;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewStoreDTO {
     private Long vendor_id;
     private String store_name;
     private City city;
     private String official_website;
     private String address;
     private String img;
     private String description;
}
