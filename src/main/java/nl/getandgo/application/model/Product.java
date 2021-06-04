package nl.getandgo.application.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "products")
public class Product {

    /**
     * Product Id
     * */
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "product_id")
    @Getter @Setter private Long product_id;

    /**
     * Store (The Product Owned by this store)
     * */

    @ManyToOne
    @JoinColumn(
            name = "store_id",
            nullable = false,
            referencedColumnName = "store_id",
            foreignKey = @ForeignKey(name = "store_id_fk")
    )
    @JsonManagedReference
    @Getter @Setter private Store store;

    /**
     * List Of Review
     * */
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Getter @Setter private List<Review> review;

    /**
     * Product Name
     * */
    @Column(name = "product_name",nullable = false)
    @Getter @Setter private String product_name;

    /**
     * Current Stock
     * */
    @Column(name = "current_stock",nullable = false)
    @Getter @Setter private int current_stock;

    /**
     * Sold
     * */
    @Column(name = "sold",nullable = false)
    @Getter @Setter private int sold;

    /**
     * Price
     * */
    @Column(name = "price",nullable = false)
    @Getter @Setter private double price;

    /**
     * Product Current Status
     * */
    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    @Getter @Setter private Status status;

    /**
     * Product Description
     * */
    @Column(name = "description",nullable = false)
    @Getter @Setter private String description;

    /**
    * Product img
    * */
    @Column(name = "product_img")
    @Getter @Setter private String img;

    /**
     * Product Category
     * */
    @Enumerated(EnumType.STRING)
    @Column(name = "category",nullable = false)
    @Getter @Setter private Category category;

    /**
     * List Of Voucher
     * (Represent selling type)
     * */
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonManagedReference
    @Getter @Setter private List<Voucher> vouchers;

    public void addVoucher(Voucher voucher){
        voucher.setProduct(this);
        vouchers.add(voucher);
    }


    //constructor
    public Product( String product_name, int current_stock, int sold, double price, Status status, String description, String img, Category category) {
        this.product_name = product_name;
        this.current_stock = current_stock;
        this.sold = sold;
        this.price = price;
        this.status = status;
        this.description = description;
        this.img = img;
        this.category = category;
        this.vouchers=new ArrayList<>();
        this.review =new ArrayList<>();
        Voucher voucher=new Voucher(price,"Standard Voucher","Standard Ticket");
        addVoucher(voucher);
    }

    /***
     * Product Status
     * - OnSale
     * - OffShelf
     * - Archive
     * */
    public enum Status{
        ONSALE,
        OFFSHELF,
        ARCHIVE
    }

    /**
     * Product Category
     * - Wellness
     * - Hotel
     * - Event
     * - Food
     * - WorkShop
     * - Speciality
     * */
    public enum Category{
        WELLNESS,
        HOTEL,
        EVENT,
        FOOD,
        WORKSHOP,
        SPECIALITY
    }

}
