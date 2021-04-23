package nl.getandgo.application.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@Entity(name = "Store")
@Table(name = "stores")
public class Store {


    /**
     * Constructor
     * @param store_name
     * @param description
     * @param city
     * @param address
     * @param img
     * @param official_website
     * */
    public Store(String store_name,
                 String description,
                 City city,
                 String address,
                 String img,
                 String official_website) {
        this.store_name = store_name;
        this.description = description;
        this.city = city;
        this.address = address;
        this.img = img;
        this.official_website = official_website;
        this.products=new ArrayList<>();
        this.vendor=null;
    }

    /***
     * Store Id
     * */
    @Id
    @SequenceGenerator(
           name = "store_sequence",
           sequenceName = "store_sequence",
           allocationSize = 1,
            initialValue = 10000
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
    @Enumerated(EnumType.STRING)
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
    @Column(name = "official_website")
    @Getter @Setter private String official_website;


    @OneToMany(
            mappedBy = "store",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonBackReference
    @Getter private List<Product> products;

    /**
     * Add New Product
     * */
    public void AddProduct(Product product){
        if(!this.products.contains(product)){
            this.products.add(product);
            product.setStore(this);
        }
    }

    /**
     * OffShelf Product
     * */
    public void OffShelfProduct(Long product_id){
        for (Product p:products) {
            if(p.getProduct_id().equals(product_id)){
                p.setStatus(Product.Status.OFFSHELF);
            }
        }
    }
    /**
     * Delete Store In System:
     * - Disconnected with Vendor
     * - Clear the Products Belong To The Store
     * */
    public void CloseStore(){
        setVendor(null);
        products.clear();
    }

}
