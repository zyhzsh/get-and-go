package nl.getandgo.application.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.location.City;

//import javax.persistence.Id;


@ToString
public class Store {
 //   @Id
    private static Long seed=10000L;
    @Getter @Setter private Long store_id;
    @Getter @Setter private Long vendor_id;
    @Getter @Setter private String store_name;
    @Getter @Setter private String description;
    @Getter @Setter private City city;
    @Getter @Setter private String address;
    @Getter @Setter private String img;
    @Getter @Setter private String official_website;

   public Store(Long vendor_id, String store_name, String description, City city, String address, String img, String official_website) {
      this.seed+=1;
      this.store_id=seed;
      this.vendor_id = vendor_id;
      this.store_name = store_name;
      this.description = description;
      this.city = city;
      this.address = address;
      this.img = img;
      this.official_website = official_website;
   }
}
