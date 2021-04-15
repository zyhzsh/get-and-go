package nl.getandgo.application.store;
import lombok.*;
import nl.getandgo.application.location.City;
import nl.getandgo.application.product.Product;
import nl.getandgo.application.user.VendorUser;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.SEQUENCE;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id",
        referencedColumnName = "user_id",
            foreignKey = @ForeignKey(
                    name = "vendor_id_fk")
    )
    @Getter @Setter private VendorUser vendor;

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

    @OneToMany(
            mappedBy = "store",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Getter private List<Product> products;

}
