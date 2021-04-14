package nl.getandgo.application.store;

import lombok.*;
import nl.getandgo.application.location.City;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

//import javax.persistence.Id;


@ToString
@NoArgsConstructor
@Entity(name = "Store")
@Table(name = "stores")
public class Store {

    /***
     * Store Id
     * */
    @Id
    @SequenceGenerator(
           name = "store_sequence",
           sequenceName = "store_sequence",
           allocationSize = 1
    )
    @GeneratedValue(
           strategy = SEQUENCE,
           generator = "store_sequence"
    )
    @Column(name = "store_id")
    @Getter @Setter private Long store_id;

    /**
     * Vendor id
     * */
    @Column(name = "vendor_id")
    @Getter @Setter private Long vendor_id;

    /**
     * Store name
     * */
    @Column(name = "store_name")
    @Getter @Setter private String store_name;

    /**
     * Description
     * */
    @Column(name = "description")
    @Getter @Setter private String description;

    /**
     * City
     * */
    @Column(name = "city",nullable = false)
    @Getter @Setter private City city;

    /**
     * Address
     * */
    @Column(name = "address",nullable = false)
    @Getter @Setter private String address;

    /**
     * Img of Store
     * */
    @Column(name = "img_link",nullable = false)
    @Getter @Setter private String img;

    /**
     * Official Website
     * */
    @Column(name = "offical_website")
    @Getter @Setter private String official_website;

   public Store(Long vendor_id, String store_name, String description, City city, String address, String img, String official_website) {
      this.vendor_id = vendor_id;
      this.store_name = store_name;
      this.description = description;
      this.city = city;
      this.address = address;
      this.img = img;
      this.official_website = official_website;
   }
}
