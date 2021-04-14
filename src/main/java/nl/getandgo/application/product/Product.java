package nl.getandgo.application.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.voucher.Voucher;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    /**
     * Product Id
     * */
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
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
//    @ManyToOne
//    @Getter @Setter private Store store;

    /**
     * List Of Review
     * */
//    @OneToMany
//    @Getter @Setter private List<Review> review;

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
    @Column(name = "category",nullable = false)
    @Getter @Setter private Category category;

    /**
     * List Of Voucher
     * (Represent selling type)
     * */
//    @OneToMany
//    @Getter @Setter private List<Voucher> vouchers;

    /***
     * Product Status
     * - OnSale
     * - OffShelf
     * - Archive
     * */
    public enum Status{
        OnSale,OffShelf,Archive
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
        Wellness,Hotel,Event,Food,WorkShop,Speciality
    }

}
