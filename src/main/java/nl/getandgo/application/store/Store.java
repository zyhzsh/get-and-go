package nl.getandgo.application.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.location.City;

@AllArgsConstructor
@ToString
public class Store {
    @Getter @Setter private Long store_id;
    @Getter @Setter private Long owner_id;
    @Getter @Setter private String store_name;
    @Getter @Setter private String description;
    @Getter @Setter private City city;
    @Getter @Setter private String address;
    @Getter @Setter private String img;
    @Getter @Setter private String official_website;
}
