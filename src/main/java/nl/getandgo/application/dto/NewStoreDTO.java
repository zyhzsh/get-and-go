package nl.getandgo.application.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import nl.getandgo.application.model.City;

@AllArgsConstructor
public class NewStoreDTO {
    @Getter private Long vendor_id;
    @Getter private String store_name;
    @Getter private City city;
    @Getter private String official_website;
    @Getter private String address;
    @Getter private String img;
    @Getter private String description;
}
